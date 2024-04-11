package me.kirar00t.kiraessentialz.commands;

// Inside imports
import me.kirar00t.kiraessentialz.misc.sendAnnouncement;

// Bukkit imports
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class announce implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        // empty title for now
        String title = "";

        if (!player.isOp()) {
            player.sendMessage(ChatColor.RED + "You do not have permission to perform this command !");
            return true;
        } else {
            StringBuilder messageBuilder = new StringBuilder();
            for (String arg : args) {
                messageBuilder.append(arg).append(" ");
            }
            String message = messageBuilder.toString().trim();
            sendAnnouncement.send(title, message, 10, 20, 10);

            return true;
        }
    }
}
