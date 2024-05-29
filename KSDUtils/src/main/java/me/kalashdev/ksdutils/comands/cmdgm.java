package me.kalashdev.ksdutils.comands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdgm implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Este comando só pode ser executado por um jogador!");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("gm")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Uso incorreto! Utilize /gm <modo>");
                return true;
            }

            String modo = args[0].toLowerCase();

            switch (modo) {
                case "0":
                case "survival":
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.GREEN + "Seu modo de jogo foi alterado para Survival!");
                    break;

                case "1":
                case "creative":
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.GREEN + "Seu modo de jogo foi alterado para Creative!");
                    break;

                case "2":
                case "adventure":
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.GREEN + "Seu modo de jogo foi alterado para Adventure!");
                    break;

                case "3":
                case "spectator":
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.GREEN + "Seu modo de jogo foi alterado para Spectator!");
                    break;

                default:
                    player.sendMessage(ChatColor.RED + "Modo de jogo inválido! Use /gm <0|1|2|3|survival|creative|adventure|spectator>");
                    break;
            }

            return true;
        }

        return false;
    }
}
