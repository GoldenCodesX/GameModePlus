package dev.goldencodes.gamemodeplus.commands;

import dev.goldencodes.gamemodeplus.managers.ClimbManager;
import dev.goldencodes.gamemodeplus.utils.ChatUtil;
import dev.goldencodes.gamemodeplus.utils.PlayerUtil;
import dev.goldencodes.gamemodeplus.utils.commandUtils.PlusCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ClimbCMD extends PlusCommand {

    public ClimbCMD() {
        super("climb",
                "&cInvalid Usage /climb",
                "Allows the player to begin Climbing walls like a Spider",
                "&cYou do not have permission to use this command!",
                Arrays.asList("cb", "cli"),
                "gamemodeplus.climb");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            boolean contains = ClimbManager.getCanClimb().contains(player.getUniqueId());

            if (args.length == 0) {
                if (contains) {
                    ClimbManager.remove(player.getUniqueId());

                    PlayerUtil.message(player, "&cClimb Disabled!");
                } else {
                    ClimbManager.add(player.getUniqueId());

                    PlayerUtil.message(player, "&aClimb Enabled!");
                }
            } else {
                player.sendMessage(usage);
            }
        } else {
            ConsoleCommandSender console = (ConsoleCommandSender) sender;

            console.sendMessage(ChatUtil.translate("&cOnly a player can use this command!"));
            return true;
        }
        return false;
    }
}
