package me.kirar00t.kiraessentialz;

// Inside imports
import me.kirar00t.kiraessentialz.commands.*;

// bukkit imports
import me.kirar00t.kiraessentialz.listeners.ChatHoverLabel;
import me.kirar00t.kiraessentialz.listeners.PlayerDeathListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class KiraEssentialz extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Register commands
        Objects.requireNonNull(getCommand("sethome")).setExecutor(new Sethome());
        Objects.requireNonNull(getCommand("home")).setExecutor(new Home());
        Objects.requireNonNull(getCommand("clearhome")).setExecutor(new ClearHome());
        Objects.requireNonNull(getCommand("show")).setExecutor(new Show());
        Objects.requireNonNull(getCommand("lastdeath")).setExecutor(new Lastdeath());

        // Register listeners
        getServer().getPluginManager().registerEvents(new ChatHoverLabel(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);

        System.out.println("KiraEssentialz plugin successfully loaded !");
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage("Welcome to the server !");
    }
    @Override
    public void onDisable() {

        System.out.println("KiraEssentialz plugin stopped !");
    }
}
