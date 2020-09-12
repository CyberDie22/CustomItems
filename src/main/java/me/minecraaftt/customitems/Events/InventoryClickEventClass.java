package me.minecraaftt.customitems.Events;

import me.minecraaftt.customitems.CustomItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class InventoryClickEventClass implements Listener {

    private final Plugin plugin = CustomItems.getPlugin(CustomItems.class);

    @EventHandler
    public void EventClass(InventoryClickEvent event){
        Inventory inventory = event.getClickedInventory();

        assert inventory != null;
        plugin.getServer().getConsoleSender().sendMessage(String.valueOf(inventory));

    }
}
