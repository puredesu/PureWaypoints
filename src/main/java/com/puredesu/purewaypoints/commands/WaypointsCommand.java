package com.puredesu.purewaypoints.commands;

import com.puredesu.purewaypoints.menusystem.PlayerMenuUtility;
import com.puredesu.purewaypoints.menusystem.menu.TestPaginatedMenu;
import com.puredesu.purewaypoints.menusystem.menu.WaypointsMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WaypointsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length > 0) {
                switch (args[0]) {
                    case "overworld":
                        new TestPaginatedMenu(new PlayerMenuUtility(p)).open(1);
                        break;
                    default:
                        break;
                }
            } else {
                new WaypointsMenu(new PlayerMenuUtility(p)).open();
            }
        } else {
            CommandUtility.notConsoleCommand();
        }
        return true;
    }
}
