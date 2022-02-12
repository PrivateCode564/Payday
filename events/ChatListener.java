package org.intellidev.payday.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.intellidev.payday.Payday;
import org.intellidev.payday.utils.StringUtils;

public class ChatListener implements Listener {

    private Payday payday;
    public ChatListener(Payday payday){
        this.payday = payday;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){

        int level = payday.taskManager.AMOUNT.get(e.getPlayer().getUniqueId());
        String prefix = payday.configManager.getPrefix(level);
        e.setFormat(e.getFormat().replace("{payday}", StringUtils.color(prefix)));
    }

}
