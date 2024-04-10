package me.kirar00t.kiraessentialz.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class enablePlugin implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        // TODO: fix auto fill (it "suggests" player names instead of loaded plugin names
        String pluginName = args[0];
        Player player = (Player) sender;
        Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);

        if (!player.isOp()) {
            player.sendMessage(ChatColor.RED + "You do not have access to this command !");

            return true;
        }
        if (plugin != null) {
            Bukkit.getPluginManager().enablePlugin(plugin);
            player.sendMessage(ChatColor.GREEN + "Plugin " + pluginName + " has been enabled successfully !");

            return true;
        } else {
            player.sendMessage(ChatColor.RED + pluginName + "Is not loaded !");

            return false;
        }
    }
}
