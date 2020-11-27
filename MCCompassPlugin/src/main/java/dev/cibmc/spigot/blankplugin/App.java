package dev.cibmc.spigot.blankplugin;

import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;


public class App extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void setRunner()


    @EventHandler
    public void playerjoin(PlayerJoinEvent event) {
        ItemStack item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Tracking Compass");
        item.setItemMeta(meta);
        event.getPlayer().getInventory().addItem(item);
    } 

    @EventHandler
    public void viewplayer(PlayerInteractEntityEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand() != null) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.COMPASS) {
                long t = System.currentTimeMillis();
                long end = t+5000;
                while (System.currentTimeMillis() < end) {
                    event.getPlayer().setCompassTarget() 
                }
            }
        }
    }
}
