package com.totem.mytotemplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MyTotemPlugin extends JavaPlugin implements Listener {

    @Override  
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("MyTotemPlugin has been enabled!");
    }

    @Override  
    public void onDisable() {
        getLogger().info("MyTotemPlugin has been disabled.");
    }

    @EventHandler  
    public void onRightClickTotem(PlayerInteractEvent event) {
        if (event.getAction().toString().contains("RIGHT_CLICK") && 
            event.getItem() != null && 
            event.getItem().getType() == Material.TOTEM_OF_UNDYING) {

            ItemStack totem = event.getItem();
            if (event.getPlayer().getInventory().getItemInOffHand().getType() == Material.AIR) {
                event.getPlayer().getInventory().setItemInOffHand(totem);
                event.getPlayer().getInventory().remove(totem);
                event.getPlayer().sendMessage("You have moved the Totem of Undying to your offhand!");
            }
        }
    }
}
