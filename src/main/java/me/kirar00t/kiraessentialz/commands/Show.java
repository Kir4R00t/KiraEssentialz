package me.kirar00t.kiraessentialz.commands;

// bukkit imports
import me.kirar00t.kiraessentialz.listeners.ChatHoverLabel;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;


@SuppressWarnings("NullableProblems")
public final class Show implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType().isAir() || !item.hasItemMeta()) {
            player.sendMessage(ChatColor.RED + "This item has no enchants");
            return true;
        }

        if (item.hasItemMeta() && Objects.requireNonNull(item.getItemMeta()).hasEnchants()) {
            // Init String Builder to fill up label with enchants
            StringBuilder labelBuilder = new StringBuilder();
            labelBuilder.append("\n");
            for (Enchantment enchantment : item.getEnchantments().keySet()) {
                int lvl = item.getEnchantmentLevel(enchantment);
                labelBuilder.append("   ").append(enchantment.getKey().getKey()).append(" - ").append(lvl).append("   ").append("\n");
            }

            String enchats = labelBuilder.toString();
            // If item has no custom name it will not be seen in chat FIX!!!
            String item_name = item.getItemMeta().getDisplayName();
            if (item_name.isEmpty()) {
                Material material = item.getType();
                item_name = material.toString();
                System.out.println("item name is - " + item_name);
            }
            ChatHoverLabel.sendHoverMessage(player, item_name , enchats);

        } else {
            player.sendMessage(ChatColor.RED + "This item has no enchants");

        }
        return true;
    }
}
