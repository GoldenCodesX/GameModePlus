package dev.goldencodes.gamemodeplus.managers;

import lombok.Getter;

import java.util.ArrayList;
import java.util.UUID;

public class ExtraHealthManager {

    @Getter
    public static ArrayList<UUID> canGetExtraHealth = new ArrayList<>();

    public static void add(UUID uuid) {
        getCanGetExtraHealth().add(uuid);
    }

    public static void remove(UUID uuid) {
        getCanGetExtraHealth().remove(uuid);
    }
}
