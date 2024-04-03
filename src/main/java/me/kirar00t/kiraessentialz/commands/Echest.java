package me.kirar00t.kiraessentialz.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Echest implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("echest")) {
            player.openInventory(player.getEnderChest());
            player.sendMessage(ChatColor.DARK_PURPLE + "Enderchest opened !");
            return true;
        }

        return false;
    }
}
