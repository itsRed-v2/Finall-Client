package net.itsRed_v2.finall.commands;

import java.util.List;

import net.itsRed_v2.finall.command.Command;
import net.itsRed_v2.finall.command.CommandInfo;
import net.itsRed_v2.finall.command.CommandSyntaxError;
import net.itsRed_v2.finall.utils.ChatUtils;

public class EchoCommand extends Command {

    private static final CommandInfo info = new CommandInfo("echo",
            "Sends back the provided message.",
            new String[]{"echo <message>"});

    @Override
    public CommandInfo getInfo() {
        return info;
    }

    @Override
    public void run(List<String> args) throws CommandSyntaxError {
        if (args.size() == 0)
            throw new CommandSyntaxError("At least 1 argument is required for this command.");

        ChatUtils.message(String.join(" ", args));
    }
}
