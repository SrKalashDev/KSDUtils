package me.kalashdev.ksdutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class cmdrestart implements CommandExecutor {

    private final JavaPlugin plugin;

    public cmdrestart(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ksdplugin")) {
            if (args.length != 1) {
                sender.sendMessage("Uso correto: /ksdplugin <nome_do_plugin>");
                return true;
            }

            String pluginName = args[0];
            Plugin targetPlugin = plugin.getServer().getPluginManager().getPlugin(pluginName);

            if (targetPlugin == null) {
                sender.sendMessage("O plugin especificado não foi encontrado.");
                return true;
            }

            plugin.getServer().getPluginManager().disablePlugin(targetPlugin);
            plugin.getServer().getPluginManager().enablePlugin(targetPlugin);

            sender.sendMessage("O plugin '" + pluginName + "' foi reiniciado com sucesso.");
            return true;
        }

        return false;
    }
}
