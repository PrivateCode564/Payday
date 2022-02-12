package org.intellidev.payday.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.intellidev.payday.Payday;

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
