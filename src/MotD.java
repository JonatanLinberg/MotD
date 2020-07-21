import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class MotD extends JavaPlugin implements Listener, CommandExecutor {
	
	private final String chatPrefix = "" + ChatColor.AQUA + ChatColor.BOLD + "[" + ChatColor.RESET + "MotD" + ChatColor.AQUA + ChatColor.BOLD +  "] - " + ChatColor.RESET;
	private FileConfiguration config = getConfig();
	private Logger log = getLogger();
	
	@Override
    public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		this.getCommand("motd").setExecutor(this);
		
		setup();
	}
    
    private void setup() {
    	config.addDefault("motd", "This is the default MotD, change this using the command \"/motd set [MotD]\" as a server operator.");
        config.options().copyDefaults(true);
        saveConfig();
    	log.info("Current MotD: " + config.getString("motd"));
    	
    }

	// Fired when plugin is disabled
    @Override
    public void onDisable() {
    	
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
    	e.getPlayer().sendMessage(chatPrefix + config.getString("motd"));
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 0) {
			if (args[0].equals("set")) {
				String motd = "";
				for (int i = 1; i < args.length; i++) {
					if (i > 1)
						motd += ' ';
					motd += args[i];
				}
				config.set("motd", motd);
				sender.sendMessage(chatPrefix + "");
				log.info("MotD set to: " + config.getString("motd"));
				return true;
			} else if (!args[0].equals("get")) {
				return false;
			}
		}
		sender.sendMessage(chatPrefix + config.getString("motd"));
    	return true;
    }
}
