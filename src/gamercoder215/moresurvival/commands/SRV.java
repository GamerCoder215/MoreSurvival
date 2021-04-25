package gamercoder215.moresurvival.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import gamercoder215.moresurvival.Main;

public class SRV implements CommandExecutor {
	
	private Main plugin;
	
	public SRV(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("srv").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("survival.user.srv")) {
			sender.sendMessage(ChatColor.GREEN + "=-= MoreSurvival v1.0.0 =-=\n\n" + ChatColor.DARK_GREEN + "/wild" + ChatColor.GREEN + " - Teleport into the wild!");
		} else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermission")));
		}
		return false;
	}
}
