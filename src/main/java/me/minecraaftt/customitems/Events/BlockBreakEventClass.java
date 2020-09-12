package me.minecraaftt.customitems.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BlockBreakEventClass implements Listener {

    @EventHandler
    public void EventClass(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (block.getType().equals(Material.DIAMOND_ORE)){
            ItemStack item = new ItemStack(Material.DIAMOND, 3);

            ItemMeta meta = item.getItemMeta();

            List<String> lore = new ArrayList<>();
            lore.add("Test");

            assert meta != null;
            meta.setLore(lore);
            item.setItemMeta(meta);

            player.getInventory().addItem(item);
        }
    }
}
