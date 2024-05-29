package me.kalashdev.ksdutils.comands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class cmdspawn implements CommandExecutor {
    private final JavaPlugin plugin; // Alteração feita aqui

    public cmdspawn(JavaPlugin plugin) { // Alteração feita aqui
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Este comando só pode ser executado por um jogador.");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("setspawn")) {
            if (!player.hasPermission("setspawn.use")) {
                player.sendMessage("§4Você não tem permissão para usar este comando.");
                return true;
            }
            // Obter a localização atual do jogador
            Location location = player.getLocation();

            // Salvar a localização no arquivo de configuração
            FileConfiguration config = plugin.getConfig();
            config.set("spawn.world", location.getWorld().getName());
            config.set("spawn.x", location.getX());
            config.set("spawn.y", location.getY());
            config.set("spawn.z", location.getZ());
            config.set("spawn.yaw", location.getYaw());
            config.set("spawn.pitch", location.getPitch());
            plugin.saveConfig();

            player.sendMessage("§aPonto de spawn definido com sucesso!");
            return true;
        }

        if (command.getName().equalsIgnoreCase("spawn")) {
            // Obter a localização do ponto de spawn do arquivo de configuração
            FileConfiguration config = plugin.getConfig();
            String worldName = config.getString("spawn.world");
            double x = config.getDouble("spawn.x");
            double y = config.getDouble("spawn.y");
            double z = config.getDouble("spawn.z");
            float yaw = (float) config.getDouble("spawn.yaw");
            float pitch = (float) config.getDouble("spawn.pitch");

            // Verificar se o mundo existe
            if (Bukkit.getWorld(worldName) == null) {
                player.sendMessage("§4O mundo de spawn não está carregado.");
                return true;
            }

            // Teleportar o jogador para o ponto de spawn
            Location spawnLocation = new Location(Bukkit.getWorld(worldName), x, y, z, yaw, pitch);
            player.teleport(spawnLocation);
            player.sendMessage("§aVocê foi teletransportado para o ponto de spawn.");
            return true;
        }

        return false;
    }
}