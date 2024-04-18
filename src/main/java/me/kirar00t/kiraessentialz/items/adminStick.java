package me.kirar00t.kiraessentialz.items;

// Bukkti imports
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class adminStick {
    public static ItemStack createAdminStick() {
        ItemStack sticc = new ItemStack(Material.STICK);

        // Sticc Meta
        ItemMeta meta = sticc.getItemMeta();

        // Make it glow
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.ARROW_DAMAGE,1,true);

        meta.setDisplayName("Admin Sticc");
        meta.setLore(java.util.Arrays.asList("Right click on your friend ;)"));

        sticc.setItemMeta(meta);
        return sticc;
    }
}
