package com.puredesu.purewaypoints.menusystem.menu;

import com.puredesu.purewaypoints.menusystem.PaginatedMenu;
import com.puredesu.purewaypoints.menusystem.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TestPaginatedMenu extends PaginatedMenu {

    public TestPaginatedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    protected String getName(int page) {
        return ("TestPageMenu [" + page + "/" + (int)Math.ceil((double)60/45) + "]");
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handle(InventoryClickEvent e) {

        int page = Integer.parseInt(super.inventory.getItem(45).getItemMeta().getLocalizedName());

        switch (e.getCurrentItem().getType()) {
            case LIME_STAINED_GLASS_PANE:
                if (e.getRawSlot() == 45) {
                    new TestPaginatedMenu(super.playerMenuUtility).open(page - 1);
                } else if (e.getRawSlot() == 53) {
                    new TestPaginatedMenu(super.playerMenuUtility).open(page + 1);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void setItems(int page) {

        List<ItemStack> allItems = new ArrayList<>();
        for (int i = 1; i < 60; i++) {
            allItems.add(new ItemStack(Material.MOSS_BLOCK, i));
        }

        ItemStack right;
        ItemMeta rightMeta;
        if (isPageValid(allItems, page + 1, 52)) {
            right = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            rightMeta = right.getItemMeta();
            rightMeta.setDisplayName(ChatColor.GREEN + "Next Page");
        } else {
            right = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            rightMeta = right.getItemMeta();
            rightMeta.setDisplayName(ChatColor.RED + "Page Unavailable");
        }
        right.setItemMeta(rightMeta);

        ItemStack left;
        ItemMeta leftMeta;
        if (isPageValid(allItems, page - 1, 52)) {
            left = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            leftMeta = left.getItemMeta();
            leftMeta.setDisplayName(ChatColor.GREEN + "Previous Page");
        } else {
            left = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            leftMeta = left.getItemMeta();
            leftMeta.setDisplayName(ChatColor.RED + "Page Unavailable");
        }
        leftMeta.setLocalizedName(Integer.toString(page));
        left.setItemMeta(leftMeta);

        super.inventory.setItem(45, left);
        super.inventory.setItem(53, right);

        List<ItemStack> itemsToDisplay = getPageItems(allItems, page, 52);

        for (ItemStack itemStack : itemsToDisplay) {
            super.inventory.setItem(getInventory().firstEmpty(), itemStack);
        }
    }


}
