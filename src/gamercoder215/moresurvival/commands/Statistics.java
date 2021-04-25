package gamercoder215.moresurvival.commands;

import java.text.NumberFormat;

import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import gamercoder215.moresurvival.Main;

public class Statistics implements CommandExecutor {
	
	private Main plugin;
	 
	public Statistics(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("statistics").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) sender.sendMessage(ChatColor.RED + "Only players can execute this command.");
		
		NumberFormat format = NumberFormat.getInstance();
		Player p = (Player) sender;
		p.sendMessage(ChatColor.GOLD + "" + ChatColor.UNDERLINE + p.getDisplayName() + "'s Statistics\n" +
		ChatColor.DARK_GREEN + format.format(p.getStatistic(Statistic.ANIMALS_BRED)) + ChatColor.GREEN + " animals bred\n" +
		ChatColor.DARK_GREEN + format.format(p.getStatistic(Statistic.BELL_RING)) + ChatColor.GREEN + " bells rang\n" +
		ChatColor.DARK_GREEN + format.format(p.getStatistic(Statistic.BREAK_ITEM)) + ChatColor.GREEN + " items broken\n" + 
		ChatColor.DARK_GREEN + format.format(p.getStatistic(Statistic.CHEST_OPENED)) + ChatColor.GREEN + " chests broken" + 
		ChatColor.DARK_GREEN + format.format(p.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD)) + ChatColor.GREEN + " damage blocked (by shield)");
		return false;
	}
}
