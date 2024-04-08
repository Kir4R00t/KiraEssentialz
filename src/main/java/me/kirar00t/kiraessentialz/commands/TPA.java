package me.kirar00t.kiraessentialz.commands;

// inside imports
import me.kirar00t.kiraessentialz.misc.tpRequest;

// bukkit imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TPA implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player rqstSender = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);


        if (command.getName().equalsIgnoreCase("tpa")) {
            if(target == null) {
                rqstSender.sendMessage(ChatColor.RED + "Your target player is not online");
                return true;
            } else if (rqstSender == target) {
                rqstSender.sendMessage(ChatColor.RED + "You cannot teleport to yourself dumbass");
                return true;
            } else {
                // send teleport request to the target player
                tpRequest.tpRequest.put(target.getUniqueId(), rqstSender.getUniqueId());

                // TODO: wait 10 seconds for acceptance and then drop the request
                rqstSender.sendMessage(ChatColor.BLUE + "TPA request has been sent");
                target.sendMessage(ChatColor.BLUE + "Player " + rqstSender.getName() + " want to teleport to you !");
                target.sendMessage(ChatColor.GREEN + " To accept use /tpaccept");

                return true;
            }
        }
        return false;
    }
}
