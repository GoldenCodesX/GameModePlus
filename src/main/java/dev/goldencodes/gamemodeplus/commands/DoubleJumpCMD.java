package dev.goldencodes.gamemodeplus.commands;

import dev.goldencodes.gamemodeplus.managers.DoubleJumpManager;
import dev.goldencodes.gamemodeplus.utils.ChatUtil;
import dev.goldencodes.gamemodeplus.utils.PlayerUtil;
import dev.goldencodes.gamemodeplus.utils.commandUtils.PlusCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class DoubleJumpCMD extends PlusCommand {

    public DoubleJumpCMD() {
        super("doublejump",
                "/doublejump",
                "Allows the player to enable DoubleJump",
                "&cInvalid Usage! /doublejump",
                Arrays.asList("dj", "doublej"),
                "gamemodeplus.doublejump");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                boolean contains = DoubleJumpManager.getCanDoubleJump().contains(player.getUniqueId());

                if (contains) {
                    DoubleJumpManager.remove(player.getUniqueId());

                    PlayerUtil.message(player, "&cDouble Jump Disabled!");
                } else {
                    DoubleJumpManager.add(player.getUniqueId());

                    PlayerUtil.message(player, "&aDouble Jump Enabled!");
                }
            } else {
                PlayerUtil.message(player, usage);
            }
        } else {
            ConsoleCommandSender console = (ConsoleCommandSender) sender;

            console.sendMessage(ChatUtil.translate("&cOnly a player can use this command!"));
            return true;
        }
        return false;
    }
}
