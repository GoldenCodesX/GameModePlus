package dev.goldencodes.gamemodeplus.commands;

import dev.goldencodes.gamemodeplus.utils.commandUtils.PlusCommand;
import dev.goldencodes.gamemodeplus.utils.commandUtils.commandMessages.HelpCMDUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class HelpCMD extends PlusCommand {

    public HelpCMD() {
        super("gamemodeplushelp",
                "&cInvalid Usage! /gamemodeplushelp",
                "Displays a help message for players who do not understand the commands",
                "&cYou do not have permission to use this command!",
                Arrays.asList("gmphelp", "ghelp"),
                "gamemodeplus.help");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {
                HelpCMDUtil.buildHelpMessage(player,
                        "&e/climb (allows the player to enable/disable Climbing)",
                        "&e/doublejump (allows the player to enable/disable Double Jumping)",
                        "/onepunch (allows the player to enable/disable 'One Shot Kill')",
                        "/health (allows the player to enable/disable Increased Health)",
                        "https://discord.gg/fXPzUgzeWy");

            }
        } else {
            ConsoleCommandSender console = (ConsoleCommandSender) sender;

            HelpCMDUtil.buildHelpMessage(console,
                    "&e/climb (allows the player to enable/disable Climbing)",
                    "&e/doublejump (allows the player to enable/disable Double Jumping)",
                    "/onepunch (allows the player to enable/disable 'One Shot Kill')",
                    "/health (allows the player to enable/disable Increased Health)");
            return true;
        }
        return false;
    }
}
