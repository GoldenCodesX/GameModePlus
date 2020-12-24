package dev.goldencodes.gamemodeplus.utils.commandUtils;

import java.lang.reflect.Field;
import java.util.List;

import dev.goldencodes.gamemodeplus.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

public abstract class PlusCommand implements CommandExecutor, TabExecutor {

    protected final String command;
    protected final String description;
    protected final List<String> alias;
    protected final String usage;
    protected final String permMessage;
    protected final String permission;

    protected static CommandMap cmap;

    public PlusCommand(String command, String permission) {
        this(command, null, null, null, null, permission);
    }

    public PlusCommand(String command, String usage, String permission) {
        this(command, usage, null, null, null, permission);
    }

    public PlusCommand(String command, String usage, String description, String permission) {
        this(command, usage, description, null, null, permission);
    }

    public PlusCommand(String command, String usage, String description, String permissionMessage, String permission) {
        this(command, usage, description, permissionMessage, null, permission);
    }

    public PlusCommand(String command, String usage, String description, List<String> aliases, String permission) {
        this(command, usage, description, null, aliases, permission);
    }

    public PlusCommand(String command, String usage, String description, String permissionMessage, List<String> aliases, String permission) {
        this.command = command.toLowerCase();
        this.usage = usage;
        this.description = description;
        this.permMessage = permissionMessage;
        this.alias = aliases;
        this.permission = permission;
    }

    public void register() {
        ReflectCommand cmd = new ReflectCommand(this.command);
        if (this.alias != null) cmd.setAliases(this.alias);
        if (this.description != null) cmd.setDescription(this.description);
        if (this.usage != null) cmd.setUsage(ChatUtil.translate(this.usage));
        if (this.permMessage != null) cmd.setPermissionMessage(ChatUtil.translate(this.permMessage));
        if (this.permission != null) cmd.setPermission(this.permission);
        getCommandMap().register("", cmd);
        cmd.setExecutor(this);
    }

    final CommandMap getCommandMap() {
        if (cmap == null) {
            try {
                final Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                f.setAccessible(true);
                cmap = (CommandMap) f.get(Bukkit.getServer());
                return getCommandMap();
            } catch (Exception e) { e.printStackTrace(); }
        } else if (cmap != null) { return cmap; }
        return getCommandMap();
    }

    public abstract boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return null;
    }
}
