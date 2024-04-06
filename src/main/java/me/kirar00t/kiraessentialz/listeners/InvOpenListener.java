package me.kirar00t.kiraessentialz.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvOpenListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Op Menu")) {
            // Prevent item moving or clicking
            event.setCancelled(true);

            // Here menu options are being handled
            if (event.getCurrentItem() != null && event.getRawSlot() == 0) {
                event.getWhoClicked().sendMessage("You clicked option1!");
            }
        }
    }
}
