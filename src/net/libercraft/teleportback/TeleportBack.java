package net.libercraft.teleportback;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class TeleportBack extends JavaPlugin {

	public List<TeleportMemory> list;
	
	@Override
	public void onEnable() {
		list = new ArrayList<TeleportMemory>();
		getServer().getPluginManager().registerEvents(new TeleportListener(this), this);
		this.getCommand("back").setExecutor(new CommandBack(this));
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public List<TeleportMemory> getList() {
		return list;
	}
	
	public List<TeleportMemory> setList(List<TeleportMemory> newList) {
		return list = newList;
	}
}
