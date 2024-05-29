package me.kalashdev.ksdutils.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class eventjoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage("§aEntrou ➤ §7" + event.getPlayer().getName() + " §c❤");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage("§cSaiu ➤ §7" + event.getPlayer().getName() + " §c✘");
    }
}
