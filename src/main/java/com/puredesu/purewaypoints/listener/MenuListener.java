package com.puredesu.purewaypoints.listener;

import com.puredesu.purewaypoints.menusystem.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) {
            return;
        }
        InventoryHolder holder = e.getClickedInventory().getHolder();
        if (holder instanceof Menu) {
            e.setCancelled(true);
            ((Menu)holder).handle(e);
        }
    }
}
