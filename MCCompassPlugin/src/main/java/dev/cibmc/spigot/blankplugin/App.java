package dev.cibmc.spigot.blankplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;


public class App extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    Player runner;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (alias.equalsIgnoreCase("runner")) {
            if (args.length == 0) {
                sender.sendMessage("Please specify a player!");
            }
            else {
                if (Bukkit.getPlayerExact(args[0]) == null) {
                    sender.sendMessage("This player does not exist");
                }
                else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    runner = target;
                }
            }
        }
        return true;
    }

    @EventHandler
    public void playeregg(PlayerEggThrowEvent event) {
        event.getPlayer().sendMessage("runner = " + runner);
    }


    @EventHandler
    public void playerjoin(PlayerJoinEvent event) {
        ItemStack item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Tracking Compass");
        item.setItemMeta(meta);
        event.getPlayer().getInventory().addItem(item);
    } 
/*
    @EventHandler
    public void viewplayer(PlayerInteractEntityEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand() != null) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.COMPASS) {
                long t = System.currentTimeMillis();
                long end = t+5000;
                while (System.currentTimeMillis() < end) {

                }
            }
        }
    }
}
*/
}