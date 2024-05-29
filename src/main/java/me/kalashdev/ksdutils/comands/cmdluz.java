package me.kalashdev.ksdutils.comands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class cmdluz implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Alternar entre visão noturna e visão normal
            if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.sendMessage(ChatColor.RED + "A visão noturna foi desativada.");
            } else {
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
                player.sendMessage(ChatColor.GREEN + "A visão noturna foi ativada.");
            }

        } else {
            sender.sendMessage("Este comando só pode ser executado por jogadores.");
        }
        return true;
    }
}
