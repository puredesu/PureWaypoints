package com.puredesu.purewaypoints;

import com.puredesu.purewaypoints.commands.WaypointsCommand;
import com.puredesu.purewaypoints.tabcompletes.WaypointsTabcomplete;
import com.puredesu.purewaypoints.listener.MenuListener;
import com.puredesu.purewaypoints.menusystem.PlayerMenuUtility;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class PureWaypoints extends JavaPlugin {

    private static PureWaypoints pureWaypoints;
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityHashMap = new HashMap<>();

    @Override
    public void onEnable() {
        pureWaypoints = this;

        this.getCommand("waypoints").setExecutor(new WaypointsCommand());
        this.getCommand("waypoints").setTabCompleter(new WaypointsTabcomplete());
        this.getServer().getPluginManager().registerEvents(new MenuListener(), this);

    }

    public static PureWaypoints getPureWaypoints() {
        return pureWaypoints;
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        if (playerMenuUtilityHashMap.containsKey(p)) {
            return playerMenuUtilityHashMap.get(p);
        } else {
            PlayerMenuUtility playerMenuUtility;
            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityHashMap.put(p, playerMenuUtility);
            return playerMenuUtility;
        }
    }
}
