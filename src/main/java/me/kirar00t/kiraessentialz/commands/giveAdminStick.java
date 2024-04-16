package me.kirar00t.kiraessentialz.commands;

// Inside imports
import me.kirar00t.kiraessentialz.items.adminStick;

// Bukkit imports
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class giveAdminStick implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (!player.isOp()) {
            player.sendMessage(ChatColor.RED + "You do not have access to this command !");
        } else {
            ItemStack funnySticc = adminStick.createAdminStick();
            player.getInventory().addItem(funnySticc);

            player.sendMessage(ChatColor.LIGHT_PURPLE + "Enjoy admin abuse :)");
        }

        return true;
    }
}
