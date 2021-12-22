package com.puredesu.purewaypoints.menusystem;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class PaginatedMenu extends Menu {

    public PaginatedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    public abstract void setItems(int page);

    public abstract String getName(int page);

    public static List<ItemStack> getPageItems(List<ItemStack> items, int page, int space) {
        int upperBound = page * space;
        int lowerBound = upperBound - space;
        List<ItemStack> itemsToDisplay = new ArrayList<>();
        for (int i = lowerBound; i < upperBound; i++) {
            try {
                itemsToDisplay.add(items.get(i));
            } catch (IndexOutOfBoundsException ignored) {
                break;
            }
        }
        return itemsToDisplay;
    }

    public static boolean isPageValid(List<ItemStack> items, int page, int space) {
        if (page <= 0) {
            return false;
        }
        int upperBound = page * space;
        int lowerBound = upperBound - space;
        return items.size() > lowerBound;
    }

    public void open(int page) {
        this.inventory = Bukkit.createInventory(this, getSlots(), getName(page));
        this.setItems(page);
        this.playerMenuUtility.getPlayer().openInventory(this.inventory);
    }
}
