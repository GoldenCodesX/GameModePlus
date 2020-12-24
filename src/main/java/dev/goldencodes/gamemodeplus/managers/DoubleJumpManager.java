package dev.goldencodes.gamemodeplus.managers;

import lombok.Getter;

import java.util.ArrayList;
import java.util.UUID;


public class DoubleJumpManager {

    @Getter
    public static ArrayList<UUID> canDoubleJump = new ArrayList<>();

    public static void add (UUID uuid) {
        getCanDoubleJump().add(uuid);
    }

    public static void remove(UUID uuid) {
        getCanDoubleJump().remove(uuid);
    }
}
