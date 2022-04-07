package com.seailz.rplace.listeners;

import com.seailz.rplace.RPlace;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    RPlace main = RPlace.getPlugin(RPlace.class);

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (main.getConfig().getBoolean(e.getPlayer().getUniqueId() + ".bypass")) return;
        e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou can't break blocks!" +
                " &7If you want to replace a block, place a different block on top."));
        e.setCancelled(true);
    }

}
