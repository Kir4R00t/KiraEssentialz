package me.kirar00t.kiraessentialz.listeners;

// bukkit imports
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;

// label imports

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;


public final class ChatHoverLabel implements Listener {
    // Basically this allows you to send custom messages with labels that appear after mousing over them
    public static void sendHoverMessage(String messageContent, String labelContent) {
        String message = ChatColor.GREEN + messageContent;
        String label = ChatColor.BLUE + labelContent;

        TextComponent component = new TextComponent(message);
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(label).create()));

        // player.spigot().sendMessage(ChatMessageType.CHAT, component); <-- this if you want to send message only to player
        // import net.md_5.bungee.api.ChatMessageType; <-- also you need to import this

        Bukkit.spigot().broadcast(component);
    }
}
