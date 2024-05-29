package me.kalashdev.ksdutils.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class blockcmd implements Listener {

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().toLowerCase();
        if (command.startsWith("/pl") || command.startsWith("/plugins") || command.startsWith("/bukkit") || command.startsWith("/kill")  || command.startsWith("/?") || command.startsWith("/help") || command.startsWith("/commands") || command.startsWith("/stop") || command.startsWith("/reload") || command.startsWith("/restart") || command.startsWith("/."))  {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "[Comando Bloqueado]");
        }
    }
}
