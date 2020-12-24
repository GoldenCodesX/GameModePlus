package dev.goldencodes.gamemodeplus.commands;

import dev.goldencodes.gamemodeplus.utils.commandUtils.PlusCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

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
        return false;
    }
}
