package me.kirar00t.kiraessentialz.listeners;

// bukkit imports
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvOpenListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Op Panel")) {
            // Prevent item moving
            event.setCancelled(true);

            // Here options are being handled
            // TODO: simplify getting option slot
            if (event.getCurrentItem() != null && event.getRawSlot() == 21) {
                event.getWhoClicked().sendMessage("You clicked option 1!");
            } else if (event.getCurrentItem() != null && event.getRawSlot() == 23) {
                event.getWhoClicked().sendMessage("You clicked option 2!");
            } else if (event.getCurrentItem() != null && event.getRawSlot() == 43) {
                event.getWhoClicked().closeInventory();
            }
        }
    }
}
