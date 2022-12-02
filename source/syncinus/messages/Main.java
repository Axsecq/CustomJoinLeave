package syncinus.messages;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public Config config;
	
	@Override
	public void onEnable() {
		
		Bukkit.getLogger().info("Loading...");
		
		config = new Config(this, "config.yml");
		
		install();
		
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		Bukkit.getLogger().info("Unloading...");
	}
	
	private void install() {
		if (!config.getFile().exists()) {
			config.getConfig().set("join", "§a + §f{PLAYER} §2joined the game.");
			config.getConfig().set("quit", "§c - §f{PLAYER} §4left the game.");
			config.save();
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent event) {
		String JOIN = config.getConfig().getString("join").replace("{PLAYER}", event.getPlayer().getName());
		
		event.setJoinMessage(JOIN);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onLeave(PlayerQuitEvent event) {
		String QUIT = config.getConfig().getString("quit").replace("{PLAYER}", event.getPlayer().getName());
		
		event.setQuitMessage(QUIT);
	}
}
