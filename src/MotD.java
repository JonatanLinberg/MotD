import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MotD extends JavaPlugin implements CommandExecutor {
	
	@Override
    public void onEnable() {
		this.getCommand("motd").setExecutor(this);
	}
    
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
    	return false;
    }
}
