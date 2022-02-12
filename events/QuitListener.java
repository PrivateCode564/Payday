package ***

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
//more imports

public class QuitListener implements Listener {

    private Payday payday;
    public QuitListener(Payday payday){
        this.payday = payday;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        payday.taskManager.saveProfile(e.getPlayer().getUniqueId());
    }

}
