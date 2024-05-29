package me.kalashdev.ksdutils.comands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdhelp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            sender.sendMessage("§f§l[§6§lCOMANDOS DO PLUGIN KSDUTILS§f§l]");
            sender.sendMessage("§a/luz - Dar efeito NightVision");
            sender.sendMessage("§a/online - Ver quantos jogadores estão online");
            sender.sendMessage("§a/dev - Desenvolvedor do Plugin");
            sender.sendMessage("§a/ajudaadmin - comandos staff");
            sender.sendMessage("§a/siteplugin - Site do Criador do Plugin");
            sender.sendMessage("§a/spawn - Comando de ir pro spawn");
            sender.sendMessage("§a/divulgar - Divulgar videos");
        } else {
            sender.sendMessage("§cEste comando so pode ser executado dentro do servidor");
        }
        return true;
    }
}
