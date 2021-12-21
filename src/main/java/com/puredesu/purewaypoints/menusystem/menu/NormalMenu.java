package com.puredesu.purewaypoints.menusystem.menu;

import com.puredesu.purewaypoints.menusystem.Menu;
import com.puredesu.purewaypoints.menusystem.PlayerMenuUtility;
import org.bukkit.Bukkit;

public abstract class NormalMenu extends Menu {

    public NormalMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    public abstract String getName();

    public abstract void setItems();

    public void open() {
        this.inventory = Bukkit.createInventory(this, getSlots(), getName());
        this.setItems();
        this.playerMenuUtility.getPlayer().openInventory(this.inventory);
    }
}
