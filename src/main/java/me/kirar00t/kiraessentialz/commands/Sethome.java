package me.kirar00t.kiraessentialz.commands;

// bukkit imports
import me.kirar00t.kiraessentialz.locations.homeLocations;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Sethome implements CommandExecutor {
    // The issue with this is the fact that when the server restarts
    // all home locations are gone.
    // Make a file with all home locations
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        // set home location
        if (command.getName().equalsIgnoreCase("sethome")) {
            homeLocations.homeLocations.put(player.getUniqueId(), player.getLocation());
            player.sendMessage(ChatColor.GREEN + "Home has been set successfully !");
            return true;
        }
        return false;
    }
}
