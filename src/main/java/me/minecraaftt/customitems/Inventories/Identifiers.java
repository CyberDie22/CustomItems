package me.minecraaftt.customitems.Inventories;

import me.minecraaftt.customitems.CustomItems;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.naming.directory.InvalidAttributesException;
import java.util.Objects;

public class Identifiers {

    public static final int CraftingTableIdentifier = 1;

    public static int getIdentifier(Inventory inventory) {
        return Objects.requireNonNull(Objects.requireNonNull(inventory.getItem(0)).getItemMeta()).getCustomModelData();
    }

    public static void setIdentifier(Inventory inventory, int identifier) {
        ItemStack IdentifierItem = inventory.getItem(0);
        assert IdentifierItem != null;
        ItemMeta IdentifierItemMeta = IdentifierItem.getItemMeta();
        assert IdentifierItemMeta != null;
        IdentifierItemMeta.setCustomModelData(identifier);
        IdentifierItem.setItemMeta(IdentifierItemMeta);
        inventory.setItem(0, IdentifierItem);
    }

    public static void safeCloseInventory(Player player, Inventory inventory) {
        int identifier = getIdentifier(inventory);

        if (identifier == CraftingTableIdentifier) {
            CraftingTable.safeCloseGUI(player, inventory);
        }

        CustomItems.getPlugin(CustomItems.class).getServer().getConsoleSender().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "CustomItems ran into an error processing a player closing an inventory! Reloading the plugin may fix this issue. If the issue persists, please report it on the github, (put link here)!");
    }
}
