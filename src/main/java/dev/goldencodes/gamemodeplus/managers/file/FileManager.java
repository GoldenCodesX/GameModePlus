package dev.goldencodes.gamemodeplus.managers.file;

import dev.goldencodes.gamemodeplus.GameModePlus;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    private final YamlConfiguration config;
    private final File file;

    public FileManager(GameModePlus plugin) {

        file = new File(plugin.getDataFolder(), "lang.yml");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException x) {
            x.printStackTrace();
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    /**
     *
     * @param bool - Enable/Disable the English Language
     */
    public void setEnglish(boolean bool) {
        config.set("english", bool);
        save();
    }

    /**
     *
     * @param bool - Enable/Disable the German Language
     */
    public void setSpanish(boolean bool) {
        config.set("spanish", bool);
        save();
    }

    /**
     *
     * @param bool - Enable/Disable the German Language
     */
    public void setGerman(boolean bool) {
        config.set("german", bool);
        save();
    }

    /**
     *
     * @return - If English has been enabled
     */
    public boolean getEnglish() {
        return config.getBoolean("english");
    }

    /**
     *
     * @return - If Spanish has been enabled
     */
    public boolean getSpanish() {
        return config.getBoolean("spanish");
    }

    /**
     *
     * @return - If Germain has been enabled
     */
    public boolean getGerman() {
        return config.getBoolean("german");
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}
