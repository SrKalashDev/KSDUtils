package me.kalashdev.ksdutils;

import me.kalashdev.ksdutils.comands.*;
import me.kalashdev.ksdutils.comands.cmdspawn;
import me.kalashdev.ksdutils.commands.cmdrestart;
import me.kalashdev.ksdutils.events.blockcmd;
import me.kalashdev.ksdutils.events.eventjoin;
import me.kalashdev.ksdutils.events.eventkill;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class KSDUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getCommand("gm").setExecutor(new cmdgm());
        getCommand("luz").setExecutor(new cmdluz());
        getCommand("dev").setExecutor(new cmdplugin());
        getCommand("online").setExecutor(new cmdOnline());
        getCommand("ajuda").setExecutor(new cmdhelp());
        getCommand("fly").setExecutor(new cmdfly());
        getCommand("siteplugin").setExecutor(new cmdsite());
        getCommand("aviso").setExecutor(new cmdalerta());
        getCommand("anunciar").setExecutor(new cmdanunciar());
        getCommand("setspawn").setExecutor(new cmdspawn(this));
        getCommand("spawn").setExecutor(new cmdspawn(this));
        getCommand("ksdplugin").setExecutor(new cmdrestart(this));
        getCommand("ajudaadmin").setExecutor(new cmdhelpadmin());
        getCommand("ksdreload").setExecutor(new cmdksdreload(this));
        getCommand("divulgar").setExecutor(new cmddivulgar());

        Bukkit.getPluginManager().registerEvents(new eventjoin(),this);
        Bukkit.getPluginManager().registerEvents(new eventkill(),this);
        Bukkit.getPluginManager().registerEvents(new blockcmd(), this);

        Bukkit.getConsoleSender().sendMessage("§6§l[KSDUtills]");
        Bukkit.getConsoleSender().sendMessage("§a[§aPlugin Ativado§a]");
        Bukkit.getConsoleSender().sendMessage("§e[Desenvolvido por KalashDev]");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§7[§cPlugin Desativado§7]");
    }
}
