package syncinus.cjlm;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import syncinus.cjlm.config.Config;
import syncinus.cjlm.listeners.EventListener;

public class CJLM extends JavaPlugin {
	
	public Config config;
	
	@Override
	public void onEnable() {
		
		Bukkit.getLogger().info("Loading...");
		
		config = new Config(this, "config.yml");
		
		install();
		
		this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
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
}
