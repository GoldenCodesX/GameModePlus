package dev.goldencodes.gamemodeplus.utils;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class PlayerUtil {

    public static void health (Player player, double health) {
        player.setHealth(health);
    }

    public static void fly(Player player, boolean access) {
        player.setAllowFlight(access);
    }

    public static void message(Player player, String message) {
        player.sendMessage(ChatUtil.translate(message));
    }

    public static boolean hasPerm(Player player, String permission) { return player.hasPermission(permission); }

    public static boolean isCreative(Player player) {
        return player.getGameMode().equals(GameMode.CREATIVE);
    }
}
