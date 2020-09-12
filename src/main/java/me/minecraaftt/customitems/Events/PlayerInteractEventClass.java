package me.minecraaftt.customitems.Events;

import me.minecraaftt.customitems.CustomItems;
import me.minecraaftt.customitems.Inventories.CraftingTable;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class PlayerInteractEventClass implements Listener {

    private final Plugin plugin = CustomItems.getPlugin(CustomItems.class);

    @EventHandler
    public void EventClass(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Block block = event.getClickedBlock();
            assert block != null;
            if (block.getType().equals(Material.CRAFTING_TABLE)){
                player.sendMessage("You right clicked a crafting table!");
                player.closeInventory();
                event.setCancelled(true);
                new CraftingTable().CraftingTableGUI(player);
                CustomItems.inIdentifiableInventory.replace(player, false, true);
            }
        }
    }
}
