package gamercoder215.moresurvival.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import gamercoder215.moresurvival.Main;

public class SRV implements CommandExecutor {
	
	private Main plugin;
	
	public SRV(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("srv").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) sender.sendMessage("Only players can execute this command.");
		
		Player p = (Player) sender;
		if (args[0].length() == 0) {
			p.sendMessage(ChatColor.GREEN + "=== MoreSurvival ===\n" + ChatColor.DARK_GREEN + "/srv help" + ChatColor.GOLD + " - " + ChatColor.GREEN + "View this page.\n");
		} else {
			
		}
		return false;
	}
	
	

}
