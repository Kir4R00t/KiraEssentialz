package me.kirar00t.kiraessentialz.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearHome implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        // clear home location
        if (command.getName().equalsIgnoreCase("clearhome")) {
            if (homeLocations.homeLocations.remove(player.getUniqueId()) != null) {
                player.sendMessage(ChatColor.BLUE + "Home has been cleared");
            } else {
                player.sendMessage(ChatColor.RED + "Cannot clear home. You need to set a home first using /sethome!");
            }
            return true;
        }
        return false;
    }
}
