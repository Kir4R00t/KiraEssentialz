package me.kirar00t.kiraessentialz.commands;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public final class Sethome implements CommandExecutor {
    private void teleportPlayer(Player player, Location location) {
        player.teleport(location);
    }

    private Location homeLocation;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // sethome location
        if (command.getName().equalsIgnoreCase("Sethome")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                homeLocation = p.getLocation();
                p.sendMessage(ChatColor.GREEN + "Home has been set successfully !");
            }
            return true;
        }

        // warp player to home
        if (command.getName().equalsIgnoreCase("Home")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (homeLocation != null) {
                    teleportPlayer(p, homeLocation);
                    p.sendMessage(ChatColor.BLUE + "Welcome home !");
                } else {
                    p.sendMessage(ChatColor.RED + "You need to set a home first using /sethome!");
                }
            }
            return true;
        }
        // clear home location
        if (command.getName().equalsIgnoreCase("Clearhome")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (homeLocation != null) {
                    homeLocation = null;
                    p.sendMessage(ChatColor.BLUE + "Home has been cleared");
                } else {
                    p.sendMessage(ChatColor.RED + "Cannot clear home. You need to set a home first using /sethome!");
                }
            }
            return true;
        }

        return false;
    }
}
