package gamercoder215.moresurvival.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import gamercoder215.moresurvival.Main;

public class Wild implements CommandExecutor {
	
	private Main plugin;
	
	public Wild(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("wild").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) sender.sendMessage(ChatColor.RED + "Only players can execute this command.");
		
		Player p = (Player) sender;
		
		if (p.hasPermission("survival.user.wild")) {
			Random rand = new Random();
			
			int xzMax = plugin.getConfig().getInt("MaxWildLimit");
			int xzMin = plugin.getConfig().getInt("MinWildLimit");
			
			double xWildCoord = (rand.nextDouble() * (xzMax - xzMin)) + xzMin;
			double zWildCoord = (rand.nextDouble() * (xzMax - xzMin)) + xzMin;
			
			Location wildCoord = new Location(Bukkit.getWorld(plugin.getConfig().getString("WildWorld")), xWildCoord, 250, zWildCoord);

			p.teleport(wildCoord);
			PotionEffect res = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 255, false, false);
			p.addPotionEffect(res);
			p.sendMessage(ChatColor.DARK_GREEN + "Good luck in the wilderness, " + p.getDisplayName() + "!");
		} else {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
		}
		return false;
	}
}
