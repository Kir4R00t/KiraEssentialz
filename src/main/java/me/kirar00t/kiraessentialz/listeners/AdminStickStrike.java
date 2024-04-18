package me.kirar00t.kiraessentialz.listeners;

// Bukkit imports
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminStickStrike implements Listener {
    @EventHandler
    public void onWandStrike(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        // TODO: This ain't workin right
        if (event.getAction().name().contains("LEFT_CLICK") && isAdminStick(item)) {
            Block block = player.getTargetBlock(null, 100);

            int x = block.getX();
            int y = block.getY();
            int z = block.getZ();

            player.getWorld().strikeLightningEffect(new org.bukkit.Location(player.getWorld(), x, y, z));
            player.sendMessage(ChatColor.AQUA + "trolled");
        } else {
            System.out.println("Strike did not work");
        }
    }

    // Method to check if the item is an admin stick
    private boolean isAdminStick(ItemStack item) {
        if (item == null || item.getType() != Material.STICK || !item.hasItemMeta()) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        return meta.hasDisplayName() && meta.getDisplayName().equals("Admin sticc");
    }
}
