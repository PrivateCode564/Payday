package org.intellidev.payday.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.intellidev.payday.Payday;

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
