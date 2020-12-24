package dev.goldencodes.gamemodeplus.utils.commandUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

final class ReflectCommand extends Command {

    private PlusCommand exe = null;

    protected ReflectCommand(String command) {
        super(command);
    }

    public void setExecutor(PlusCommand exe) {
        this.exe = exe;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (exe != null) {
            return exe.onCommand(sender, this, commandLabel, args);
        }
        return false;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
        if (exe != null) {
            return exe.onTabComplete(sender, this, alias, args);
        }
        return null;
    }
}
