package me.kalashdev.ksdutils.comands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class cmdalerta implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("aviso")) {
            if (args.length == 0) {
                sender.sendMessage("§1");
                sender.sendMessage(ChatColor.RED + "Uso: /aviso <mensagem>");
                sender.sendMessage("§1");
                return true;
            }

            String mensagem = String.join(" ", args);
            enviarAlerta(mensagem);
            return true;
        }
        return false;
    }

    private void enviarAlerta(String mensagem) {
        Bukkit.broadcastMessage(ChatColor.RED + "[Aviso] " + ChatColor.WHITE + mensagem);
    }
}
