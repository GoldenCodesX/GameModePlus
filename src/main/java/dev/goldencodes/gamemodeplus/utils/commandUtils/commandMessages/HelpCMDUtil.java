package dev.goldencodes.gamemodeplus.utils.commandUtils.commandMessages;

import dev.goldencodes.gamemodeplus.utils.ChatUtil;
import dev.goldencodes.gamemodeplus.utils.PlayerUtil;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public abstract class HelpCMDUtil {

    public static void buildHelpMessage(Player player,
                                        String firstHelp,
                                        String secondHelp,
                                        String thirdHelp,
                                        String fourthHelp,
                                        String discordLink) {

        TextComponent lastButton = new TextComponent(ChatUtil.translate("&5&lHere"));

        lastButton.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatUtil.translate("&eJoin the Support Server!")).create()));
        lastButton.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, discordLink));

        TextComponent lastMessage = new TextComponent(ChatUtil.translate(" &e&lNeed further assistance? Join GoldenCodes Support Server "));
        lastMessage.addExtra(lastButton);

        PlayerUtil.message(player, "&e>>> &e&lGameModePlus &aHelp &e<<<", true);
        PlayerUtil.message(player, "&7&l[&e&lGMP&7&l] &e> " + firstHelp, false);
        PlayerUtil.message(player, "&7&l[&e&lGMP&7&l] &e> " + secondHelp, false);
        PlayerUtil.message(player, "&7&l[&e&lGMP&7&l] &e> " + thirdHelp, false);
        PlayerUtil.message(player, "&7&l[&e&lGMP&7&l] &e> " + fourthHelp, true);
        PlayerUtil.messageSpigot(player, lastMessage);
    }

    public static void buildHelpMessage(ConsoleCommandSender console,
                                        String firstHelp,
                                        String secondHelp,
                                        String thirdHelp,
                                        String fourthHelp) {

        console.sendMessage(ChatUtil.translate("&e>>> &e&lGameModePlus &aHelp &e<<<"));
        console.sendMessage(" ");
        console.sendMessage(ChatUtil.translate("&7&l[&e&lGMP&7&l] &e> " + firstHelp));
        console.sendMessage(" ");
        console.sendMessage(ChatUtil.translate("&7&l[&e&lGMP&7&l] &e> " + secondHelp));
        console.sendMessage(" ");
        console.sendMessage(ChatUtil.translate("&7&l[&e&lGMP&7&l] &e> " + thirdHelp));
        console.sendMessage(" ");
        console.sendMessage(ChatUtil.translate("&7&l[&e&lGMP&7&l] &e> " + fourthHelp));
    }
}
