package dev.goldencodes.gamemodeplus.listeners;

import dev.goldencodes.gamemodeplus.managers.ExtraDamageManager;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ExtraDamageListener implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {

        boolean contains = ExtraDamageManager.getCanDoExtraDamage().contains(event.getDamager().getUniqueId());

        try {
            if (contains) {
                if (event.getDamager() instanceof Player) {

                    if (event.getEntity() instanceof LivingEntity) {

                        ((LivingEntity) event.getEntity()).setHealth(0.0);

                    }
                } else if (event.getDamager() instanceof Projectile) {

                    final Projectile projectile = (Projectile) event.getDamager();

                    if (projectile.getShooter() instanceof Player) {

                        if (event.getEntity() instanceof LivingEntity) {
                            ((LivingEntity) event.getEntity()).setHealth(0.0);
                        }
                    }
                }
            }
        } catch (final NullPointerException x) {
            x.printStackTrace();
        }
    }
}
