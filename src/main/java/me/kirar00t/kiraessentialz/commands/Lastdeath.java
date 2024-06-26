package me.kirar00t.kiraessentialz.commands;

// inside imports
import me.kirar00t.kiraessentialz.listeners.PlayerDeathListener;

// bukkit imports
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// Java imports
import java.util.Arrays;

public final class Lastdeath implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("lastdeath")) {
            double[] deathCoords = PlayerDeathListener.getLastDeathCoordinates(player.getUniqueId());
            System.out.println(Arrays.toString(deathCoords));

            if (deathCoords != null) {
                // Math.ceil to round up for better readability
                player.sendMessage(ChatColor.BLUE + "Your last death coordinates are:" + "\n"
                        + "X: " + (int)Math.ceil(deathCoords[0]) + "\n"
                        + "Y: " + (int)Math.ceil(deathCoords[1]) + "\n"
                        + "Z: " + (int)Math.ceil(deathCoords[2]));

            } else {
                player.sendMessage(ChatColor.RED + "You do not have any saved death coordinates");
            }
            return true;
        }
        return false;
    }
}
