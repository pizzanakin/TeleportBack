package net.libercraft.teleportback;

import java.util.UUID;

import org.bukkit.Location;

public class TeleportMemory {

	private UUID uniqueID;
	private Location returnPoint;
	
	public TeleportMemory(UUID _uniqueID, Location _returnPoint) {
		uniqueID = _uniqueID;
		returnPoint = _returnPoint;
	}
	
	public UUID getUniqueID() {
		return uniqueID;
	}
	
	public Location getLocation() {
		return returnPoint;
	}
	
	public UUID setUniqueID(UUID newID) {
		return uniqueID = newID;
	}
	
	public Location setLocation(Location newLocation) {
		return returnPoint = newLocation;
	}
}
