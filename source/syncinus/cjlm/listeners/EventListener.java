package syncinus.cjlm.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import syncinus.cjlm.CJLM;

public class EventListener implements Listener {
	
	private CJLM plugin;
	
	public EventListener(CJLM instance) {
		this.plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent event) {
		String JOIN = plugin.config.getConfig().getString("join").replace("{PLAYER}", event.getPlayer().getName());
		
		event.setJoinMessage(JOIN);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onLeave(PlayerQuitEvent event) {
		String QUIT = plugin.config.getConfig().getString("quit").replace("{PLAYER}", event.getPlayer().getName());
		
		event.setQuitMessage(QUIT);
	}
	
}
