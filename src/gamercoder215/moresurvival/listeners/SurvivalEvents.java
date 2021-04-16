package gamercoder215.moresurvival.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import gamercoder215.moresurvival.Main;

public class SurvivalEvents implements Listener {
	
	private Main plugin;
	
	public SurvivalEvents(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	FileConfiguration config = plugin.getConfig();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', config.getString("WelcomeMessage").replaceAll("%player%", p.getDisplayName()).replaceAll("%uuid%", p.getUniqueId().toString())));
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', config.getString("LeaveMessage").replaceAll("%player%", p.getDisplayName()).replaceAll("%uuid%", p.getUniqueId().toString())));
	}
}
