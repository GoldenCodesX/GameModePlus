package dev.goldencodes.gamemodeplus.managers;

import lombok.Getter;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.UUID;

public class ClimbManager {

    @Getter
    public static ArrayList<Integer> NoClimbBlocks;

    @Getter
    public static ArrayList<UUID> canClimb = new ArrayList<>();

    public static void add(UUID uuid) {
        getCanClimb().add(uuid);
    }

    public static void remove(UUID uuid) {
        getCanClimb().remove(uuid);
    }

    public void defineNoClimbBlocks() {
        NoClimbBlocks.add(Material.GLASS_PANE.getId());
        NoClimbBlocks.add(44);
        NoClimbBlocks.add(126);
        NoClimbBlocks.add(Material.OAK_STAIRS.getId());
        NoClimbBlocks.add(Material.JUNGLE_STAIRS.getId());
        NoClimbBlocks.add(Material.BIRCH_STAIRS.getId());
        NoClimbBlocks.add(Material.SPRUCE_STAIRS.getId());
        NoClimbBlocks.add(Material.COBBLESTONE_STAIRS.getId());
        NoClimbBlocks.add(Material.BRICK_STAIRS.getId());
        NoClimbBlocks.add(Material.BIRCH_STAIRS.getId());
        NoClimbBlocks.add(Material.STONE_STAIRS.getId());
        NoClimbBlocks.add(Material.NETHER_BRICK_STAIRS.getId());
        NoClimbBlocks.add(Material.SANDSTONE_STAIRS.getId());
        NoClimbBlocks.add(Material.OAK_FENCE.getId());
        NoClimbBlocks.add(Material.DARK_OAK_FENCE_GATE.getId());
        NoClimbBlocks.add(Material.NETHER_BRICK_FENCE.getId());
        NoClimbBlocks.add(Material.LADDER.getId());
        NoClimbBlocks.add(Material.VINE.getId());
        NoClimbBlocks.add(Material.RED_BED.getId());
        NoClimbBlocks.add(Material.BLACK_BED.getId());
        NoClimbBlocks.add(Material.IRON_BARS.getId());
        NoClimbBlocks.add(Material.SPRUCE_SIGN.getId());
        NoClimbBlocks.add(Material.LEVER.getId());
        NoClimbBlocks.add(Material.OAK_DOOR.getId());
        NoClimbBlocks.add(Material.PISTON.getId());
        NoClimbBlocks.add(Material.MOVING_PISTON.getId());
        NoClimbBlocks.add(Material.TRIPWIRE_HOOK.getId());
        NoClimbBlocks.add(93);
        NoClimbBlocks.add(94);
        NoClimbBlocks.add(Material.OAK_BOAT.getId());
        NoClimbBlocks.add(Material.MINECART.getId());
        NoClimbBlocks.add(Material.CAKE.getId());
        NoClimbBlocks.add(Material.CAKE.getId());
        NoClimbBlocks.add(Material.WATER.getId());
        NoClimbBlocks.add(Material.LAVA.getId());
    }
}
