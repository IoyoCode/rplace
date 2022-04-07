package com.seailz.rplace.listeners;

import com.seailz.rplace.RPlace;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class OnCommand implements Listener {
    RPlace main = RPlace.getPlugin(RPlace.class);

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (main.getConfig().getBoolean(e.getPlayer().getUniqueId() + ".bypass") || e.getPlayer().hasPermission("command.bypass")) return;
        else {
            e.getPlayer().sendMessage(ChatColor.RED + "You can't run commands.");
            e.setCancelled(true);
        }
    }

}
