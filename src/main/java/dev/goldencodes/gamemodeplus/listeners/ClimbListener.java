package dev.goldencodes.gamemodeplus.listeners;

import dev.goldencodes.gamemodeplus.GameModePlus;
import dev.goldencodes.gamemodeplus.managers.ClimbManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClimbListener implements Listener {
    /**
     * @TODO: Make this code more organized and readable
     */
    Map<String, ArrayList<Block>> vineMap;
    public GameModePlus plugin;

    public ClimbListener(final GameModePlus instance) {
        this.vineMap = new HashMap<String, ArrayList<Block>>();
        this.plugin = instance;
        this.plugin = instance;
    }

    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent event) {
        final Player player = event.getPlayer();

        if (ClimbManager.getCanClimb().contains(player.getUniqueId())) {

            final BlockFace bf = this.yawToFace(player.getLocation().getYaw());
            final Block block = player.getLocation().getBlock().getRelative(bf);

            if (block.getType() != Material.AIR) {
                for (int i = 0; i < 300; i++) {

                    final Block temp = block.getLocation().add(0.0, (double)i, 0.0).getBlock();
                    final Block opp = player.getLocation().add(0.0, (double)i, 0.0).getBlock();
                    final Block aboveOpp = opp.getLocation().add(0.0, 1.0, 0.0).getBlock();

                    int counter = 0;

                    for (int k = 0; k < ClimbManager.getNoClimbBlocks().size(); k++) {
                        if (temp.getType() != Material.AIR && temp.getType().getId() != ClimbManager.getNoClimbBlocks().get(k)) {
                            ++counter;
                        }
                    }
                    if (counter != ClimbManager.getNoClimbBlocks().size()) {
                        break;
                    }
                    if (opp.getType() != Material.AIR && opp.getType() != Material.TALL_GRASS
                            && opp.getType() != Material.SUNFLOWER && opp.getType() != Material.ROSE_BUSH) {
                        break;
                    }
                    if (aboveOpp.getType() == Material.AIR) {
                        player.sendBlockChange(opp.getLocation(), Material.VINE, (byte)0);
                        this.addVines(player, opp);
                    }
                    player.setFallDistance(0.0f);
                }
            }
            else {
                for (int i = 0; i < this.getVines(player).size(); i++) {
                    player.sendBlockChange(this.getVines(player).get(i).getLocation(), Material.AIR, (byte)0);
                }
                this.getVines(player).clear();
            }
        }
    }

    public ArrayList<Block> getVines(final Player player) {

        if (this.vineMap.containsKey(player.getName())) {
            return this.vineMap.get(player.getName());
        }

        final ArrayList temp = new ArrayList();

        return (ArrayList<Block>)temp;
    }

    public void setVines(final Player player, final ArrayList<Block> vines) {
        this.vineMap.put(player.getName(), vines);
    }

    public void addVines(final Player player, final Block vine) {
        ArrayList updated;
        updated = this.getVines(player);
        updated.add(vine);
        this.setVines(player, updated);
    }

    public BlockFace yawToFace(final float yaw) {
        final BlockFace[] axis = { BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH, BlockFace.EAST };
        return axis[Math.round(yaw / 90.0f) & 0x3];
    }
}
