package me.kirar00t.kiraessentialz.listeners;

// inside imports
import me.kirar00t.kiraessentialz.deathLocations;

// bukkit imports
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

// Java imports
import java.util.UUID;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void PlayerDeathEvent(PlayerDeathEvent event) {
        Player player = event.getEntity();
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();

        setLastDeathCoordinates(player.getUniqueId(), x, y ,z);
    }

    public void setLastDeathCoordinates(UUID playerId, double x, double y, double z) {
        deathLocations.deathLocations.put(playerId, new double[]{x, y, z});
    }
    public static double[] getLastDeathCoordinates(UUID playerId) {
        return deathLocations.deathLocations.get(playerId);
    }

}
