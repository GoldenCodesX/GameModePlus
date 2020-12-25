package dev.goldencodes.gamemodeplus.managers.update;

import dev.goldencodes.gamemodeplus.GameModePlus;
import dev.goldencodes.gamemodeplus.utils.ChatUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;

public class Updater {

    public void update(int id) {
        try {
            HttpURLConnection c = (HttpURLConnection)new URL("http://www.spigotmc.org/api/general.php").openConnection();
            c.setDoOutput(true);
            c.setRequestMethod("POST");
            c.getOutputStream().write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + id).getBytes("UTF-8"));

            String oldVersion = GameModePlus.getInstance().getDescription().getVersion();
            String newVersion = new BufferedReader(new InputStreamReader(c.getInputStream())).readLine().replaceAll("[a-zA-Z ]", "");

            if(!newVersion.equals(oldVersion)) {
                ChatUtil.log( GameModePlus.getPREFIX() + " &aThere is a new update available for &eGameModePlus!", Level.WARNING);
            }
        }
        catch(Exception e) {
            //update failed, most likely to spigot being down or the server not having internet connection
            ChatUtil.log(GameModePlus.getPREFIX() + " &cUnable to search for new updates for GameModePlus!", Level.WARNING);
        }
    }
}
