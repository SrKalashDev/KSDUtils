package me.kalashdev.ksdutils.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class eventkill implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Player killer = player.getKiller();

        if (killer != null) {
            String playerName = player.getName();
            String killerName = killer.getName();
            String deathMessage = ChatColor.RED + playerName + " foi destruido por " + killerName + "!"; // Mensagem personalizada
            event.setDeathMessage(deathMessage);
        } else {
            String playerName = player.getName();
            String deathMessage = ChatColor.RED + playerName + " morreu de forma feia!";
            event.setDeathMessage(deathMessage);
        }
    }
}
