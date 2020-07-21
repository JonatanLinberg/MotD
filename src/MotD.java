import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class MotD extends JavaPlugin implements Listener, CommandExecutor {
	
	private final String chatPrefix = ChatColor.AQUA + (ChatColor.BOLD + "[MotD] - ");
	
	@Override
    public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		this.getCommand("motd").setExecutor(this);
		
		setup();
	}
    
    private void setup() {
    	
    }

	// Fired when plugin is disabled
    @Override
    public void onDisable() {
    	
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
    	
    	
    	e.getPlayer().sendMessage("");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length > 0) {
			if (args[0].equals("set")) {
				
				sender.sendMessage("");
				this.getLogger().info("MotD set to: ");
				return true;
			} else if (args[0].equals("get")) {
				
				sender.sendMessage("");
				return true;
			}
		}
    	return false;
    }
}
