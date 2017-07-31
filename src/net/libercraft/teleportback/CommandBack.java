package net.libercraft.teleportback;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBack implements CommandExecutor{

	TeleportBack plugin;
	
	public CommandBack(TeleportBack _plugin) {
		plugin = _plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		// Make sure the command was executed by a player
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			// Check if the player has permission
			if (!player.hasPermission("teleportback.back")) {
				player.sendMessage(ChatColor.RED + "I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe this is in error.");
				return true;
			}

			List<TeleportMemory> list = plugin.getList();
			
			// Check if the memory list is empty
			if (list.isEmpty()) {
				player.sendMessage(ChatColor.GOLD + "[TP Back]" + ChatColor.GRAY + " Error: No previous location was found.");
				return true;
			}
			
			// Check the memory list to find the player's previous location
			for (TeleportMemory entry:list) {
				if (player.getUniqueId().equals(entry.getUniqueID())) {
					player.teleport(entry.getLocation());
					
				// Notify the player that no location was found
				} else {
					player.sendMessage(ChatColor.GOLD + "[TP Back]" + ChatColor.GRAY + " Error: No previous location was found.");
				}
				return true;
			} 
		}
		return false;
	}

}
