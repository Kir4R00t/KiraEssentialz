package me.kirar00t.kiraessentialz.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class open_opMenu {
    public static void open_opMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9, "Op Menu");

        ItemStack option1 = new ItemStack(Material.DIAMOND_SWORD);
        inv.setItem(0, option1);

        ItemStack option2 = new ItemStack(Material.GOLDEN_APPLE);
        inv.setItem(1, option2);

        player.openInventory(inv);
    }
}
