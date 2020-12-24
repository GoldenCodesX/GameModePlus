package dev.goldencodes.gamemodeplus.managers;

import lombok.Getter;

import java.util.ArrayList;
import java.util.UUID;

public class ExtraDamageManager {

    @Getter
    public static ArrayList<UUID> canDoExtraDamage = new ArrayList<>();

    public static void add(UUID uuid) {
        getCanDoExtraDamage().add(uuid);
    }

    public static void remove(UUID uuid) {
        getCanDoExtraDamage().remove(uuid);
    }
}
