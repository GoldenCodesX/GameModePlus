package dev.goldencodes.gamemodeplus.utils;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class PlayerUtil {

    public static void health(Player player, double health) {
        player.setHealth(health);
    }

    public static void fly(Player player, boolean access) {
        player.setAllowFlight(access);
        player.setFlying(access);
    }

    public static void message(Player player, String message) {
        player.sendMessage(ChatUtil.translate(message));
    }

    public static void message(Player player, String message, boolean putSpace) {
        if (putSpace) {
            message(player, message);
            message(player, " ");
        }
    }

    public static void messageSpigot(Player player, TextComponent component) {
        player.spigot().sendMessage(component);

    }

    public static boolean hasPerm(Player player, String permission) {
        return player.hasPermission(permission);
    }

    public static boolean isCreative(Player player) {
        return player.getGameMode().equals(GameMode.CREATIVE);
    }
}
