package gamercoder215.moresurvival;

import org.bukkit.plugin.java.JavaPlugin;

import gamercoder215.moresurvival.commands.*;
import gamercoder215.moresurvival.listeners.*;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		saveDefaultConfig();
		
		new SRV(this);
		new Wild(this);
		// Commands
		// Events
		new SurvivalEvents(this);
	}
}
