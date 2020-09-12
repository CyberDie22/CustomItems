package me.minecraaftt.customitems;

import me.minecraaftt.customitems.Events.BlockBreakEventClass;
import me.minecraaftt.customitems.Events.InventoryClickEventClass;
import me.minecraaftt.customitems.Events.PlayerInteractEventClass;
import me.minecraaftt.customitems.Inventories.Identifiers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class CustomItems extends JavaPlugin implements Listener {

    public static HashMap<Player, Boolean> inIdentifiableInventory = new HashMap<Player, Boolean>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.getServer().getPluginManager().registerEvents(new BlockBreakEventClass(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerInteractEventClass(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryClickEventClass(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        for(Player player : Bukkit.getServer().getOnlinePlayers()){
            if (inIdentifiableInventory.get(player).equals(true)) {
                Identifiers.safeCloseInventory(player, player.getOpenInventory().getTopInventory());
            }
        }
        inIdentifiableInventory.clear();
    }
}
