package net.itsRed_v2.finall.command;

import java.util.List;

import net.itsRed_v2.finall.utils.ChatUtils;

public abstract class Command {

    public abstract CommandInfo getInfo();

    public abstract void run(List<String> args) throws CommandSyntaxError;

    public void sendSyntax() {
        for (String str : getInfo().syntax())
            ChatUtils.message(CommandProcessor.PREFIX + str);
    }

}
