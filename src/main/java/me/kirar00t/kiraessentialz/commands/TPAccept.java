package me.kirar00t.kiraessentialz.commands;

// inside imports
import me.kirar00t.kiraessentialz.locations.tpRequest;

// bukkit imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// java imports
import java.util.Objects;
import java.util.UUID;

public class TPAccept implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player player = (Player) sender;

        // First check if the request is stored
        if(tpRequest.tpRequest.containsKey(player.getUniqueId())) {
            if (command.getName().equalsIgnoreCase("TPAccept")) {
                UUID rqstSenderUUID = tpRequest.tpRequest.get(player.getUniqueId());
                Player rqstSender = Bukkit.getPlayer(rqstSenderUUID);
                Objects.requireNonNull(rqstSender).teleport(player.getLocation());
                player.sendMessage(ChatColor.GREEN + "Teleported successfully !");

                // remove request after tp
                tpRequest.tpRequest.remove(player.getUniqueId());
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "TPA Error");
                return false;
            }
        } else {
            player.sendMessage(ChatColor.RED + "You do not have any pending TPA requests !");
            return false;
        }
    }
}
