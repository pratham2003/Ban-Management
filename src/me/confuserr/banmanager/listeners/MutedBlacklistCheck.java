package me.confuserr.banmanager.listeners;

import me.confuserr.banmanager.BanManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class MutedBlacklistCheck implements Listener {
	private BanManager plugin;

	public MutedBlacklistCheck(BanManager instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		if(!plugin.mutedPlayersBy.containsKey(event.getPlayer().getName()))
			return;
		
		// Split the command
		String[] args = event.getMessage().split(" ");
		
		// Get rid of the first /
		String cmd = args[0].replace("/", "");
		
		// Check to see if its blacklisted
	    if(plugin.mutedBlacklist.contains(cmd)) {
	    	// Cancel it
	    	event.setCancelled(true);
	    }
	}
}
