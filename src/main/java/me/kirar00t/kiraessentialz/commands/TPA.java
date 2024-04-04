package me.kirar00t.kiraessentialz.commands;

import me.kirar00t.kiraessentialz.locations.tpRequest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TPA implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player rqstSender = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);


        if (command.getName().equalsIgnoreCase("tpa")) {
            if(target == null) {
                rqstSender.sendMessage(ChatColor.RED + "Your target player is not online");
                return false;
            } else if (rqstSender == target) {
                rqstSender.sendMessage(ChatColor.RED + "You cannot teleport to yourself dumbass");
                return false;
            } else {
                // send teleport request to the target player
                tpRequest.tpRequest.put(target.getUniqueId(), rqstSender.getUniqueId());

                rqstSender.sendMessage(ChatColor.BLUE + "TPA request has been sent");
                target.sendMessage(ChatColor.BLUE + "Player " + rqstSender.getName() + " want to teleport to you !");
                target.sendMessage(ChatColor.GREEN + "To accept use /tpaccept" + ChatColor.GRAY + "(request will expire in 10 seconds)");

                return true;
            }
        }
        return false;
    }
}
