package dev.goldencodes.gamemodeplus.commands;

import dev.goldencodes.gamemodeplus.managers.ExtraDamageManager;
import dev.goldencodes.gamemodeplus.utils.ChatUtil;
import dev.goldencodes.gamemodeplus.utils.PlayerUtil;
import dev.goldencodes.gamemodeplus.utils.commandUtils.PlusCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ExtraDamageCMD extends PlusCommand {

    public ExtraDamageCMD() {
        super("onepunch",
                "&cInvalid Usage! /onepunch",
                "Allows players to enable/disable there 'one shot kill' abilities",
                "&cYou do not have permission to use this command!",
                Arrays.asList("punch", "onep"),
                "gamemodeplus.onepunch");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            boolean contains = ExtraDamageManager.getCanDoExtraDamage().contains(player.getUniqueId());

            if (args.length == 0) {
                if (contains) {
                    ExtraDamageManager.remove(player.getUniqueId());

                    PlayerUtil.message(player, "&cOnePunch Mode Disabled!");
                } else {
                    ExtraDamageManager.add(player.getUniqueId());

                    PlayerUtil.message(player, "&aOnePunch Mode Enabled!");
                }
            } else {
                PlayerUtil.message(player, usage);
            }
        } else {
            ConsoleCommandSender console = (ConsoleCommandSender) sender;

            console.sendMessage(ChatUtil.translate("&cOnly players can use this command!"));
            return true;
        }
        return false;
    }
}
