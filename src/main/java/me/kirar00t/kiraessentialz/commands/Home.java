package me.kirar00t.kiraessentialz.commands;

// bukkit imports
import me.kirar00t.kiraessentialz.locations.homeLocations;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("home")) {
            Location homeLocation = homeLocations.homeLocations.get(player.getUniqueId());
            if (homeLocation != null) {
                teleportPlayer(player, homeLocation);
                player.sendMessage(ChatColor.BLUE + "Welcome home !");
            } else {
                player.sendMessage(ChatColor.RED + "You need to set a home first using /sethome!");
            }
            return true;
        }
        return false;
    }
    private void teleportPlayer(Player player, Location location) {
        player.teleport(location);
    }
}
