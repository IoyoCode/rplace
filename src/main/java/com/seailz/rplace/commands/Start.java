package com.seailz.rplace.commands;

import com.seailz.rplace.RPlace;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Start implements CommandExecutor {
    RPlace main = RPlace.getPlugin(RPlace.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!p.hasPermission("rplace.Start")) return true;
        if (!main.getConfig().getBoolean("enabled")) return true;
        Bukkit.broadcastMessage(ChatColor.GREEN + "R/PLACE HAS BEEN STARTED!");
        main.getConfig().set("enabled", true);
        return true;
    }
}
