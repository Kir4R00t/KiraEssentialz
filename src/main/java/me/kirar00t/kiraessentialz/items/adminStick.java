package me.kirar00t.kiraessentialz.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class adminStick {
    public static ItemStack createAdminStick() {
        ItemStack sticc = new ItemStack(Material.STICK);

        // Sticc Meta
        ItemMeta meta = sticc.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("Admin Sticc");
            meta.setLore(java.util.Arrays.asList("Right click on your friend ;)"));

            sticc.setItemMeta(meta);
        }

        return sticc;
    }
}
