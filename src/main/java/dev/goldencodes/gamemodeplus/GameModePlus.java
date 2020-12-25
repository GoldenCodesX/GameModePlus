package dev.goldencodes.gamemodeplus;

import dev.goldencodes.gamemodeplus.commands.*;
import dev.goldencodes.gamemodeplus.listeners.ClimbListener;
import dev.goldencodes.gamemodeplus.listeners.DoubleJumpListener;
import dev.goldencodes.gamemodeplus.listeners.ExtraDamageListener;
import dev.goldencodes.gamemodeplus.managers.file.FileManager;
import dev.goldencodes.gamemodeplus.managers.update.Updater;
import dev.goldencodes.gamemodeplus.utils.ChatUtil;
import dev.goldencodes.gamemodeplus.utils.metrics.Metrics;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class GameModePlus extends JavaPlugin {

    @Getter
    private static GameModePlus instance;

    @Getter
    private final static String PREFIX = "&c[&eGameModePlus&c]";

    @Override
    public void onEnable() {
        instance = this;

        int pluginId = 9752;
        new Metrics(this, pluginId);

        init();
    }

    public void init() {
        ChatUtil.log(getPREFIX() + " &aGameModePlus has successfully been enabled! \n&aCreated By: &eGoldenCodes", Level.INFO);

        new Updater().update(83746);
        new FileManager(this);

        registerCommands();
        registerListeners();
    }

    public void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new ClimbListener(this), this);
        pm.registerEvents(new DoubleJumpListener(), this);
        pm.registerEvents(new ExtraDamageListener(), this);
    }

    public void registerCommands() {
        new HelpCMD().register();
        new ExtraHealthCMD().register();
        new DoubleJumpCMD().register();
        new ClimbCMD().register();
        new ExtraDamageCMD().register();
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
