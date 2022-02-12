package ***

import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
//more imports

public class ConfigManager {

    private Payday payday;
    public ConfigManager(Payday payday){
        this.payday = payday;
    }

    private File file;
    private YamlConfiguration config;

    public String getPrefix(int i){
        file = new File(payday.getDataFolder(), "prefixes.yml");
        config = YamlConfiguration.loadConfiguration(file);

        return config.getString("prefix." + i);
    }

    public void initializePrefixes(){

        file = new File(payday.getDataFolder(), "prefixes.yml");

        if(!(file.exists())){
            config = YamlConfiguration.loadConfiguration(file);

            //heavy load(bad practise dont copy)
            for(int i = 0; i < 10000; i++){
                config.set("prefix." + i, "[" + i + "]");
            }

            try{
                config.save(file);
            }catch(IOException e){}
        }

    }

    public void initialize(){

        file = new File(payday.getDataFolder(), "config.yml");


        if(!(file.exists())){
            config = YamlConfiguration.loadConfiguration(file);


            for(int i = 1; i < 15; i++){
                for(Group groups : payday.luckPermsAPI.getGroupManager().getLoadedGroups()){

                    if(!(config.contains(groups.getName()))) {
                        config.set(i + "." + groups.getName(), 100);
                    }
                    try{
                        config.save(file);
                    }catch(IOException ex){}

                }
            }

        }


    }

    public int getReward(int Payday, UUID uuid){
        file = new File(payday.getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(file);
        User user = payday.luckPermsAPI.getUserManager().getUser(uuid);
        return config.getInt(Payday + "." + user.getPrimaryGroup());
    }


}
