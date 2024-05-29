package me.kalashdev.ksdutils.comands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdplugin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            sender.sendMessage("§c[§fPlugin Desenvolvido por KalashDev§c]");
            sender.sendMessage("§c[§fCanal do Desenvolvedor: KalashCraft§c]");
        } else {
            sender.sendMessage("§cEste comando so pode ser executado dentro do servidor");
        }
        return true;
    }
}
