package dev.goldencodes.gamemodeplus.listeners;

import dev.goldencodes.gamemodeplus.managers.DoubleJumpManager;
import dev.goldencodes.gamemodeplus.utils.PlayerUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJumpListener implements Listener {

    @EventHandler
    public void onFlight(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();

        if (!PlayerUtil.isCreative(player) && DoubleJumpManager.getCanDoubleJump().contains(player.getUniqueId())) {
            event.setCancelled(true);

            PlayerUtil.fly(player, true);

            player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));
            player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1, 1);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        final Player player = event.getPlayer();

        if (!PlayerUtil.isCreative(player) && player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR
                && DoubleJumpManager.getCanDoubleJump().contains(player.getUniqueId()) && !player.isFlying()) {

           PlayerUtil.fly(player ,true);

        } else {
            if (PlayerUtil.isCreative(player)) {

                PlayerUtil.fly(player, false);

            }
        }
    }
}
