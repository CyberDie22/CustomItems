package me.minecraaftt.customitems.Events;

import me.minecraaftt.customitems.CustomItems;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEventClass {

    public void EventClass(PlayerQuitEvent event){
        Player player = event.getPlayer();
        CustomItems.inIdentifiableInventory.remove(player);
    }
}
