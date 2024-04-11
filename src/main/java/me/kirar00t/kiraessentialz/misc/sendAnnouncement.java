package me.kirar00t.kiraessentialz.misc;

// Bukkit imports
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class sendAnnouncement {
    public static void send(String title, String message, int fadeIn, int stay, int fadeOut) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendTitle(title, message, fadeIn, stay, fadeOut);
        }
    }
}
