package me.kirar00t.kiraessentialz.commands;

// inside imports
import me.kirar00t.kiraessentialz.menus.open_opMenu;

// bukkit imports
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpMenu implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        // Obviously prevent players access to this menu
        if(!player.isOp()) {
            player.sendMessage(ChatColor.RED + "You have to be an operator to access this menu");
        } else {
            open_opMenu.open_opMenu(player);
        }
        return true;
    }
}
