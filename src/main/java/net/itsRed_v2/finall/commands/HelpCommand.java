package net.itsRed_v2.finall.commands;

import java.util.Collection;
import java.util.List;

import net.itsRed_v2.finall.command.Command;
import net.itsRed_v2.finall.command.CommandInfo;
import net.itsRed_v2.finall.command.CommandList;
import net.itsRed_v2.finall.command.CommandSyntaxError;
import net.itsRed_v2.finall.utils.ChatUtils;

public class HelpCommand extends Command {

    private static final CommandInfo info = new CommandInfo("help",
            "Displays help for commands.",
            new String[]{
                    "help",
                    "help <commandName>"
            });
    
    @Override
    public CommandInfo getInfo() {
        return info;
    }

    @Override
    public void run(List<String> args) throws CommandSyntaxError {

        if (args.size() > 1)
            throw new CommandSyntaxError("Too many arguments");

        if (args.size() == 0) {
            commandList();
            return;
        }

        Command cmd = CommandList.getByName(args.get(0));

        if (cmd == null)
            ChatUtils.message("Unknown command: §6" + args.get(0));
        else
            commandInfo(cmd);
    }

    private void commandList() {
        Collection<Command> commands = CommandList.getCommands();

        ChatUtils.message("§3List of all available commands:");

        for (Command cmd : commands)
            ChatUtils.message(cmd.getInfo().name());
    }

    private void commandInfo(Command cmd) {
        CommandInfo inf = cmd.getInfo();
        ChatUtils.message("§9Info about command §f" + inf.name());
        ChatUtils.message("§3Description: §f" + inf.description());
        ChatUtils.message("§3Syntax: §7(one by line)");
        cmd.sendSyntax();
    }
}
