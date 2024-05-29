package me.kalashdev.ksdutils.comands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class cmdanunciar implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("anunciar")) {
            if (args.length == 0) {
                sender.sendMessage("§1");
                sender.sendMessage(ChatColor.RED + "Uso: /anunciar <mensagem>");
                sender.sendMessage("§1");
                return true;
            }

            String mensagem = String.join(" ", args);
            enviarAnuncio(mensagem);
            return true;
        }
        return false;
    }

    private void enviarAnuncio(String mensagem) {
        Bukkit.broadcastMessage("§6§lANUNCIO: " + ChatColor.WHITE + mensagem);
    }
}
