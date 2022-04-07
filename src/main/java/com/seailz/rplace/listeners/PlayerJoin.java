package com.seailz.rplace.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler (priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent e)  {
        e.getPlayer().setGameMode(GameMode.CREATIVE);
        e.getPlayer().setGameMode(GameMode.CREATIVE);
        e.getPlayer().teleport(new Location(Bukkit.getWorld("rplace"), 0, 100, 0));
        e.getPlayer().sendTitle(ChatColor.RED + "Welcome to r/place!", "&fTo get started, place a block!", 3, 3, 3);
        e.getPlayer().setAllowFlight(true);
        e.getPlayer().setFlying(true);
    }
}
