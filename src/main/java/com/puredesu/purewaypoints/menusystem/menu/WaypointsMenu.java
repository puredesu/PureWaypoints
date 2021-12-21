package com.puredesu.purewaypoints.menusystem.menu;

import com.puredesu.purewaypoints.menusystem.Menu;
import com.puredesu.purewaypoints.menusystem.MenuUtility;
import com.puredesu.purewaypoints.menusystem.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WaypointsMenu extends NormalMenu {

    public WaypointsMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getName() {
        return "Waypoints";
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public void handle(InventoryClickEvent e) {

        switch (e.getCurrentItem().getType()) {
            case NETHERRACK:
                e.getWhoClicked().sendMessage("You clicked nether");
                break;
            case MOSS_BLOCK:
                new TestPaginatedMenu(new PlayerMenuUtility((Player)e.getWhoClicked())).open(1);
                break;
            case END_STONE:
                e.getWhoClicked().sendMessage("You clicked end");
                break;
            default:
                break;
        }
    }

    @Override
    public void setItems() {
        ItemStack nether = new ItemStack(Material.NETHERRACK);
        ItemStack overworld = new ItemStack(Material.MOSS_BLOCK);
        ItemStack end = new ItemStack(Material.END_STONE);
        ItemMeta netherMeta = nether.getItemMeta();
        netherMeta.setDisplayName(ChatColor.RED + "Nether");
        nether.setItemMeta(netherMeta);
        ItemMeta overworldMeta = overworld.getItemMeta();
        overworldMeta.setDisplayName(ChatColor.GREEN + "Overworld");
        overworld.setItemMeta(overworldMeta);
        ItemMeta endMeta = end.getItemMeta();
        endMeta.setDisplayName(ChatColor.WHITE + "End");
        end.setItemMeta(endMeta);
        super.inventory.setItem(2, nether);
        super.inventory.setItem(4, overworld);
        super.inventory.setItem(6, end);
        MenuUtility.fillEmptySlots(super.inventory);
    }
}
