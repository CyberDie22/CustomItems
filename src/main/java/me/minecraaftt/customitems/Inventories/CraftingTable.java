package me.minecraaftt.customitems.Inventories;

import me.minecraaftt.customitems.CustomItems;
import me.minecraaftt.customitems.CustomMaterial;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CraftingTable {

    private final Plugin plugin = CustomItems.getPlugin(CustomItems.class);

    private static List<Integer> craftingSlots = new ArrayList<>();


    public void CraftingTableGUI(Player player){

        craftingSlots.add(10);
        craftingSlots.add(11);
        craftingSlots.add(12);
        craftingSlots.add(19);
        craftingSlots.add(20);
        craftingSlots.add(21);
        craftingSlots.add(28);
        craftingSlots.add(29);
        craftingSlots.add(30);

        Inventory inventory = plugin.getServer().createInventory(null, 54, ChatColor.GRAY + "Craft Item");

        // Setting Unusable Black Glass Slots
        for (int i=0;i<=53;i++){
            inventory.setItem(i, CustomMaterial.BlackUnusableSlot());
        }

        // Adding Inventory Identifier
        Identifiers.setIdentifier(inventory, 1);

        // Removing Slots for Crafting Grid
        for (int i = 10; i>=10&&i<=12; i++){
            inventory.setItem(i, new ItemStack(Material.AIR));
        }
        for (int i = 19; i>=19&&i<=21; i++){
            inventory.setItem(i, new ItemStack(Material.AIR));
        }
        for (int i = 28; i>=28&&i<=30; i++){
            inventory.setItem(i, new ItemStack(Material.AIR));
        }

        // Changing Bottom Row to Unusable Red Glass Slots and adding Close Button
        for (int i = 45; i<=53; i++){
            inventory.setItem(i, CustomMaterial.RedUnusableSlot());
        }
        inventory.setItem(49, CustomMaterial.Close());

        player.openInventory(inventory);
    }

    public static void safeCloseGUI(Player player, Inventory inventory){

        for (int i : craftingSlots) {
            player.getInventory().addItem(inventory.getItem(i));
        }
        CustomItems.inIdentifiableInventory.replace(player, true, false);
        player.closeInventory();
    }
}
