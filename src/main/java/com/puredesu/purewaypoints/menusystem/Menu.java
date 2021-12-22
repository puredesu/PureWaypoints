package com.puredesu.purewaypoints.menusystem;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class Menu implements InventoryHolder {

    protected Inventory inventory;

    protected PlayerMenuUtility playerMenuUtility;

    protected Menu(PlayerMenuUtility playerMenuUtility) {
        this.playerMenuUtility = playerMenuUtility;
    }

    public abstract int getSlots();

    public abstract void handle(InventoryClickEvent e);

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }
}
