package me.kirar00t.kiraessentialz.listeners;

// bukkit imports
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

// label imports
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;


public final class ChatHoverLabel implements Listener {
    // Basically this allows you to send custom messages with labels that appear after mousing over them
    public static void sendHoverMessage(Player player, String messageContent, String labelContent) {
        String message = ChatColor.GREEN + messageContent;
        String label = ChatColor.BLUE + labelContent;

        TextComponent component = new TextComponent(message);
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(label).create()));

        // player.spigot().sendMessage(ChatMessageType.CHAT, component);
        // I guess the one below is working ? :v
        Bukkit.spigot().broadcast(component);
    }
}