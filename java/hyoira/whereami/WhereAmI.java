package hyoira.whereami;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class WhereAmI extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("WhereAmI plugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("WhereAmI plugin has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("myspot")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                int x = player.getLocation().getBlockX();
                int y = player.getLocation().getBlockY();
                int z = player.getLocation().getBlockZ();
                String messege = ChatColor.GREEN + player.getName() +  "はココにいるよ (" + x + ", " + y + ", " + z + ")";
                Bukkit.getServer().broadcastMessage(messege);
            } else {
                sender.sendMessage(ChatColor.RED + "このコマンドはプレイヤーのみが実行できます");
            }
            return true;
        }
        return false;
    }
}
