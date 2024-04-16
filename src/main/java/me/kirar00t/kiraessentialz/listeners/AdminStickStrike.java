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
    // TODO: DEBUG THIS
    @EventHandler
    public void onWandStrike(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (event.getAction().name().contains("LEFT_CLICK") && isCustomStick(item)) {
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

    // Method to check if it's a real admin wand or just a normal sticc
    // This may not be the best way to make it "secure"
    private boolean isCustomStick(ItemStack item) {
        if (item == null || item.getType() != Material.STICK || !item.hasItemMeta()) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        return meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.RESET + "Admin Sticc");
    }
}
