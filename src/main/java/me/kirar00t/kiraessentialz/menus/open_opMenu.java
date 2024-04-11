package me.kirar00t.kiraessentialz.menus;

// bukkit imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// Java imports
import java.util.Arrays;
import java.util.Objects;


public class open_opMenu {
    private static ItemStack createOption(Material material, String displayName, String... lore) {
        ItemStack option = new ItemStack(material);
        ItemMeta meta = option.getItemMeta();

        Objects.requireNonNull(meta).setDisplayName(displayName);

        // lore == item label menu
        if (lore != null && lore.length > 0) {
            meta.setLore(Arrays.asList(lore));
        }

        option.setItemMeta(meta);
        return option;
    }

    public static void open_opMenu(Player player) {
        // One row == 9
        Inventory inv = Bukkit.createInventory(null, 54, "Op Panel");

        // "frame" item
        ItemStack frame = createOption(Material.BLACK_STAINED_GLASS_PANE, "", "");

        // Add chaos mode switch only if KiraChaos plugin is loaded
        if (Bukkit.getPluginManager().isPluginEnabled("KiraChaos")) {
            ItemStack chaosSwitch = createOption(Material.END_CRYSTAL, ChatColor.BLUE + "Chaos mode", ChatColor.DARK_PURPLE + "Enable/Disable Chaos mode");
            inv.setItem(42, chaosSwitch);
        }

        ItemStack option1 = createOption(Material.GOLDEN_APPLE, ChatColor.BLUE + "Option 2", ChatColor.DARK_PURPLE + "This is the second option.");


        ItemStack exit = createOption(Material.BARRIER, ChatColor.RED + "Exit", ChatColor.RED + "Quit operator panel");

        // Put everything into the "menu"

        // This is making a "frame"
        for (int i = 0; i <= 8; i++) { inv.setItem(i, frame); }
        for (int i = 45; i <= 53; i++) { inv.setItem(i, frame); }
        for (int i = 0; i <= 45; i+=9) { inv.setItem(i, frame); }
        for (int i = 8; i <= 53; i+=9) { inv.setItem(i, frame); }

        // Here are all the options in the panel
        inv.setItem(10, option1);
        inv.setItem(43, exit);

        player.openInventory(inv);
    }
}
