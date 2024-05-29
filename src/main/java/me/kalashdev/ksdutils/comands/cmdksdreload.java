package me.kalashdev.ksdutils.comands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class cmdksdreload implements CommandExecutor {

    private final JavaPlugin plugin;

    public cmdksdreload(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("reload.use")) {
            sender.sendMessage(ChatColor.RED + "Você não tem permissão para reiniciar o plugin.");
            return true;
        }

        if (args.length > 0) {
            sender.sendMessage(ChatColor.RED + "Uso correto: /ksdreload");
            return true;
        }

        Bukkit.getScheduler().runTask(plugin, () -> {
            // Desativar o plugin
            Bukkit.getPluginManager().disablePlugin(plugin);
            // Ativar o plugin
            Bukkit.getPluginManager().enablePlugin(plugin);
        });

        sender.sendMessage(ChatColor.GREEN + "Plugin reiniciado com sucesso.");
        return true;
    }
}
