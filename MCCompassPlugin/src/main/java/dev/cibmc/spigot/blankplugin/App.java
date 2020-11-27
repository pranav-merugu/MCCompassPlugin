package dev.cibmc.spigot.blankplugin;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class App extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void creaturespawn(CreatureSpawnEvent event) {
        
        if (event.getEntityType() == EntityType.CREEPER) {

            Creeper creeper = (Creeper) event.getEntity();
            creeper.setPowered(true);
            
        }
    } 
}
