package com.seailz.rplace.commands;

import com.seailz.rplace.RPlace;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bypass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        RPlace main = RPlace.getPlugin(RPlace.class);
        Player p = (Player) sender;
        if (!p.hasPermission("command.bypass")) return true;
        System.out.println("Test");
        if (main.getConfig().getBoolean(p.getUniqueId() + ".bypass")) {
            p.sendMessage(ChatColor.GREEN + "We've disabled bypass!");
            main.getConfig().set(p.getUniqueId() + ".bypass", false);
            main.saveConfig();
        }
        else {
            p.sendMessage(ChatColor.GREEN + "We've enabled bypass!");
            main.getConfig().set(p.getUniqueId() + ".bypass", true);
            main.saveConfig();
        }


        return true;
    }
}
