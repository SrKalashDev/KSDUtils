package me.kalashdev.ksdutils.comands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cmddivulgar implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("divulgar")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Apenas jogadores podem usar este comando!");
                return true;
            }

            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage("Uso correto: /divulgar <link>");
                return true;
            }

            String link = args[0];

            if (!isValidLink(link)) {
                player.sendMessage("O link fornecido não é válido. Por favor, forneça um link do YouTube ou Twitch.");
                return true;
            }

            String formattedMessage = "§c[Divulgação] §f" + player.getName() + ": " + link;
            player.getServer().broadcastMessage(formattedMessage);
            return true;
        }
        return false;
    }

    // Verifica se o link é do YouTube ou Twitch
    private boolean isValidLink(String link) {
        Pattern youtubePattern = Pattern.compile("^(https?\\:\\/\\/)?(www\\.)?(youtube\\.com|youtu\\.?be)\\/.+$");
        Pattern twitchPattern = Pattern.compile("^(https?\\:\\/\\/)?(www\\.)?(twitch\\.tv)\\/.+$");

        Matcher youtubeMatcher = youtubePattern.matcher(link);
        Matcher twitchMatcher = twitchPattern.matcher(link);

        return youtubeMatcher.matches() || twitchMatcher.matches();
    }
}
