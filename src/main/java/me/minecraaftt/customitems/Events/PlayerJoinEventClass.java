package me.minecraaftt.customitems.Events;

import me.minecraaftt.customitems.CustomItems;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventClass {

    public void EventClass(PlayerJoinEvent event){
        Player player = event.getPlayer();
        CustomItems.inIdentifiableInventory.put(player, false);
    }
}
