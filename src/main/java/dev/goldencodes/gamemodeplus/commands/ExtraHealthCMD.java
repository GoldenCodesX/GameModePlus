package dev.goldencodes.gamemodeplus.commands;

import dev.goldencodes.gamemodeplus.managers.ExtraHealthManager;
import dev.goldencodes.gamemodeplus.utils.PlayerUtil;
import dev.goldencodes.gamemodeplus.utils.commandUtils.PlusCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ExtraHealthCMD extends PlusCommand {

    public ExtraHealthCMD() {
        super("healthx",
                "&cInvalid Usage! /healthx <player> <amount>",
                "Allows players to set how much Health they should have",
                "You do not have permission to use this command!",
                Arrays.asList("hx", "health"),
                "gamemodeplus.health");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            boolean contains = ExtraHealthManager.getCanGetExtraHealth().contains(player.getUniqueId());

            switch (args.length) {
                case 0:
                    if (contains) { // Disable
                        ExtraHealthManager.remove(player.getUniqueId());

                        PlayerUtil.message(player, "&cYour health has been reset!");
                        PlayerUtil.health(player, 20.0);
                    } else { // Enable
                        ExtraHealthManager.add(player.getUniqueId());

                        PlayerUtil.message(player, "&aYour health has been increased by 1 bar!");
                        PlayerUtil.health(player, 40.0);
                    }
                    break;

                case 1:
                    if (ExtraHealthManager.getCanGetExtraHealth().contains(player.getUniqueId())) { // Disable
                        ExtraHealthManager.remove(player.getUniqueId());

                        PlayerUtil.message(player, "&cYour health has been reset!");
                        PlayerUtil.health(player, 20.0);
                    } else { // Enable
                        ExtraHealthManager.add(player.getUniqueId());

                        double argument = Double.parseDouble(args[0]);

                        PlayerUtil.message(player, "&aYour health has been increased by " + args[0]);
                        PlayerUtil.health(player, argument);
                    }
                    break;

                default:
                    PlayerUtil.message(player, usage);
                    break;
            }
        }
        return false;
    }
}
