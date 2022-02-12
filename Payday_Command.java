package ***

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
//more imports

import java.util.concurrent.TimeUnit;

public class Payday_Command implements CommandExecutor {

    private Payday payday;
    public Payday_Command(Payday payday){
        this.payday = payday;
    }

    //using bukkit's commandexecutor not custom one.
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
        if(args.length == 0) {
            int track = payday.taskManager.PAYDAY.get(p.getUniqueId());
            int time = payday.taskManager.TIME.get(p.getUniqueId());
            long times = TimeUnit.SECONDS.toMillis((long) (3600 - time));
            p.sendMessage(StringUtils.color("&eYou will receive your next reward for Payday &f" + track + " &ein &f" +
                    DateFormatter.formatMilliseconds(times)));

        }

        }
        return false;
    }
}
