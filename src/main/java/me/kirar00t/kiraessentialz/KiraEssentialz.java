package me.kirar00t.kiraessentialz;

// Inside imports
import me.kirar00t.kiraessentialz.commands.ClearHome;
import me.kirar00t.kiraessentialz.commands.Home;
import me.kirar00t.kiraessentialz.commands.Sethome;

// bukkit imports
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class KiraEssentialz extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        System.out.println("KiraEssentialz plugin successfully loaded !");
        // Register commands
        getCommand("sethome").setExecutor(new Sethome());
        getCommand("home").setExecutor(new Home());
        getCommand("clearhome").setExecutor(new ClearHome());
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage("Welcome to the serveerrrr !!!!!");
    }
    @Override
    public void onDisable() {
        System.out.println("KiraEssentialz plugin stopped !");
    }
}
