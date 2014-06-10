package me.supermaxman.nodrop;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;



public class NoDrop extends JavaPlugin {
	public static NoDrop plugin;
    public static FileConfiguration conf;
	public static final Logger log = Logger.getLogger("Minecraft");
	
	static HashMap<Integer, Integer> items = new HashMap<Integer, Integer>();
	
	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		conf = plugin.getConfig();
		setupConfig();
		getServer().getPluginManager().registerEvents(new NoDropListener(), plugin);
		log.info(getName() + " has been enabled.");
		
	}
	
	public void onDisable() {
		
		log.info(getName() + " has been disabled.");
	}
	
	void setupConfig() {
		try {
			if (conf.isConfigurationSection("items")) {
	           for (Map.Entry<String, Object> entry : conf.getConfigurationSection("items").getValues(false).entrySet()) {
	        	   items.put(Integer.parseInt(entry.getKey()), conf.getInt("items." + entry.getKey()));
	           }
			}
		} catch (Exception e) {
			log.warning("[" + plugin.getName() + "] Items are invalid in config.yml! Could not load the values.");
		}
	}
	
	
	    
	
}