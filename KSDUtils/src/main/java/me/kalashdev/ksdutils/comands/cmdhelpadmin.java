package me.kalashdev.ksdutils.comands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdhelpadmin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            sender.sendMessage("§f§l[§6§lCOMANDOS DO PLUGIN KSDUTILS§f§l]");
            sender.sendMessage("§a/gm - Trocar gamemode");
            sender.sendMessage("§a/fly - Voar");
            sender.sendMessage("§a/anunciar - Comando de anunciar eventos");
            sender.sendMessage("§a/aviso - Comando de avisar restarts");
            sender.sendMessage("§a/ksdplugin <name> - Comando de reniciar plugins");
            sender.sendMessage("§a/setspawn - Comando de setar spawn");
            sender.sendMessage("§a/ksdreload - Comando de setar spawn");
        } else {
            sender.sendMessage("§cEste comando so pode ser executado dentro do servidor");
        }
        return true;
    }
}
