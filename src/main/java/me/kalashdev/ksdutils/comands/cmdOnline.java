package me.kalashdev.ksdutils.comands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdOnline implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            if (command.getName().equalsIgnoreCase("online")) {
                commandSender.sendMessage("§eOnline:" + Bukkit.getOnlinePlayers().size());
            }
        }
        return true;
    }
}
