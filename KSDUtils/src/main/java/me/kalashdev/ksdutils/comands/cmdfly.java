package me.kalashdev.ksdutils.comands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdfly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("fly")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cEste comando só pode ser usado por jogadores!");
                return true;
            }

            Player player = (Player) sender;

            if (player.hasPermission("fly.use")) { // Verifica se o jogador tem permissão
                if (args.length == 0) {
                    // Ativa ou desativa o voo do jogador
                    player.setAllowFlight(!player.getAllowFlight());
                    player.sendMessage("§eModo de voo " + (player.getAllowFlight() ? "§eativado!" : "§edesativado!"));
                } else {
                    player.sendMessage("§cUso incorreto! Use /fly para ativar ou desativar o voo.");
                }
            } else {
                player.sendMessage("§cVocê não tem permissão para usar este comando!");
            }
            return true;
        }
        return false;
    }
}
