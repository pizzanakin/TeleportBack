package net.libercraft.teleportback;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportListener implements Listener {
	
	TeleportBack plugin;
	
	public TeleportListener(TeleportBack _plugin) {
		plugin = _plugin;
	}
	
	@EventHandler
	public void onTeleportEvent(PlayerTeleportEvent event) {
		List<TeleportMemory> list = plugin.getList();
		Player player = event.getPlayer();
		
		// Check for the player's UUID in the current list of recorded players
		for (TeleportMemory entry:list) {
			
			// If the UUID is found, replace the entry with the new location.
			if (player.getUniqueId().equals(entry.getUniqueID())) {
				Integer index = list.indexOf(entry);
				list.set(index, new TeleportMemory(player.getUniqueId(), event.getFrom()));
				return;
			}
		}
		
		// Add the player to the end of the list if the UUID is not found
		list.add(new TeleportMemory(player.getUniqueId(), event.getFrom()));
	}

}
