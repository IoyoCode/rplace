package com.seailz.rplace.listeners;

import com.seailz.rplace.RPlace;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {
    RPlace main = RPlace.getPlugin(RPlace.class);

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (main.getConfig().getBoolean(p.getUniqueId() + ".bypass")) return;
        if (!main.getConfig().getBoolean("enabled")) {
            e.setCancelled(true);
            return;
        } // Check if r/place is enabled
        if (!main.getConfig().getBoolean(p.getUniqueId() + ".canPlace")) {
            p.sendMessage(ChatColor.RED + "Your countdown isn't up yet!");
            e.setCancelled(true);
            return;
        } // Check if the player can build
        if (e.getBlock().getType() == Material.BEDROCK)  {
            p.sendMessage(ChatColor.RED + "You can't build with bedrock!");
            e.setCancelled(true);
            return;
        } // Check if the block they are placing is bedrock
        if (e.getBlock().getLocation().subtract(0, 1, 0).getBlock().getType() != Material.BEDROCK && e.getBlock().getLocation().subtract(0, 2, 0).getBlock().getType() != Material.BEDROCK) {
            p.sendMessage(ChatColor.RED + "You are not building within the canvas.");
            e.setCancelled(true);
            return;
        } // Check if they are building within the canvas

        if (e.getBlock().getLocation().subtract(0, 1, 0).getBlock().getType() == Material.BEDROCK) {
            p.sendMessage(ChatColor.GREEN + "You placed a" + e.getBlock().getType().toString().toLowerCase().replaceAll("_", " ") + "!");
            main.getConfig().set(p.getUniqueId() + ".canPlace", false);
            main.saveConfig();

            Bukkit.getScheduler().runTaskLater(main, () -> {
                main.getConfig().set(p.getUniqueId() + ".canPlace", true);
                main.saveConfig();
            }, 20);
        }
        else if (e.getBlock().getLocation().subtract(0, 2, 0).getBlock().getType() == Material.BEDROCK) {
            p.sendMessage(ChatColor.GREEN + "You placed a " + e.getBlock().getType().toString().toLowerCase().replaceAll("_", " ") + "!");
            main.getConfig().set(p.getUniqueId() + ".canPlace", false);
            main.saveConfig();
            e.setCancelled(true);
            e.getBlock().getLocation().subtract(0, 1, 0).getBlock().setType(e.getBlock().getType());
            Bukkit.getScheduler().runTaskLater(main, () -> {
                main.getConfig().set(p.getUniqueId() + ".canPlace", true);
                main.saveConfig();
            }, 20);
        }
    }

}
