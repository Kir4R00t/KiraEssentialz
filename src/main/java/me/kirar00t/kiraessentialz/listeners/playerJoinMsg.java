package me.kirar00t.kiraessentialz.listeners;

// Inside imports
import me.kirar00t.kiraessentialz.misc.sendAnnouncement;

// Bukkit imports
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoinMsg implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        sendAnnouncement.send(ChatColor.BLUE + "Welcome to the server !", ChatColor.LIGHT_PURPLE + "I like fresh bread",10, 20, 10);
    }
}
