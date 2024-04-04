package me.kirar00t.kiraessentialz.commands;

import me.kirar00t.kiraessentialz.locations.tpRequest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;
import java.util.UUID;

public class TPAccept implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player player = (Player) sender;
        // First check
        if(tpRequest.tpRequest.containsKey(player.getUniqueId())) {
            if (command.getName().equalsIgnoreCase("TPAccept")) {
                // rqstSenderUUID = commandsedner.getUniqueID
                UUID rqstSenderUUID = tpRequest.tpRequest.get(player.getUniqueId());
                Player rqstSender = Bukkit.getPlayer(rqstSenderUUID);
                Objects.requireNonNull(rqstSender).teleport(player.getLocation());
                player.sendMessage(ChatColor.GREEN + "Teleported successfully !");

                // remove request
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
