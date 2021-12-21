package com.puredesu.purewaypoints.commands;

import com.puredesu.purewaypoints.PureWaypoints;

public class CommandUtility {
    public static void notConsoleCommand() {
        PureWaypoints.getPureWaypoints().getLogger().info("This command can only be used in-game!");
    }
}
