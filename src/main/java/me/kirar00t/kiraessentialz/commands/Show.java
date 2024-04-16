package me.kirar00t.kiraessentialz.commands;

// Bsukkit imports
import me.kirar00t.kiraessentialz.listeners.ChatHoverLabel;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// Java imports
import java.util.Objects;


public final class Show implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType().isAir() || !item.hasItemMeta()) {
            player.sendMessage(ChatColor.RED + "This item has no enchants");
            return true;
        }

        if (item.hasItemMeta() && Objects.requireNonNull(item.getItemMeta()).hasEnchants()) {
            // String Builder to fill up label with enchants
            StringBuilder labelBuilder = new StringBuilder();
            labelBuilder.append("\n");
            for (Enchantment enchantment : item.getEnchantments().keySet()) {
                int lvl = item.getEnchantmentLevel(enchantment);
                labelBuilder.append("   ").append(enchantment.getKey().getKey()).append(" - ").append(lvl).append("   ").append("\n");
            }

            String enchats = labelBuilder.toString();
            String item_name = item.getItemMeta().getDisplayName();

            // If item has no custom name --> get material type as name
            if (item_name.isEmpty()) {
                Material material = item.getType();
                item_name = material.toString();
                System.out.println("item name is - " + item_name);
            }
            ChatHoverLabel.sendHoverMessage(item_name, enchats);
            return true;

        } else {
            player.sendMessage(ChatColor.RED + "This item has no enchants");
        }
        return false;
    }
}
