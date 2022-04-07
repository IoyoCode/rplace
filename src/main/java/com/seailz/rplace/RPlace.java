package com.seailz.rplace;

import com.seailz.rplace.commands.Bypass;
import com.seailz.rplace.commands.Start;
import com.seailz.rplace.listeners.BlockBreak;
import com.seailz.rplace.listeners.BlockPlace;
import com.seailz.rplace.listeners.OnCommand;
import com.seailz.rplace.listeners.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class RPlace extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BlockPlace(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new OnCommand(), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getCommand("start").setExecutor(new Start());
        getCommand("bypass").setExecutor(new Bypass());
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
