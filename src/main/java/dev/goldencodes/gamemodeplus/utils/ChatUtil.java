package dev.goldencodes.gamemodeplus.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatUtil {

    public static String translate(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static void log(String message, Level level) {
        Logger log = Bukkit.getLogger();

        if (level.equals(Level.INFO)) {
            log.info(translate(message));
        } else if (level.equals(Level.WARNING)) {
            log.warning(translate(message));
        } else if (level.equals(Level.SEVERE)) {
            log.severe(translate(message));
        }
    }
}
