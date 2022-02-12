package ***

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
//more events

public class JoinListener implements Listener {

    private Payday payday;
    public JoinListener(Payday payday){
        this.payday = payday;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        payday.taskManager.loadProfile(e.getPlayer().getUniqueId());
    }

}
