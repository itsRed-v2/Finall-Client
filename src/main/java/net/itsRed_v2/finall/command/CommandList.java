package net.itsRed_v2.finall.command;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.itsRed_v2.finall.commands.EchoCommand;
import net.itsRed_v2.finall.commands.HelpCommand;
import org.jetbrains.annotations.Nullable;

public final class CommandList {

    private static final Map<String, Command> cmds = new HashMap<>();
    static {
        Set<Command> commands = new HashSet<>();
        commands.add(new EchoCommand());
        commands.add(new HelpCommand());

        for (Command cmd : commands)
            cmds.put(cmd.getInfo().name(), cmd);
    }

    public static @Nullable Command getByName(String name) {
        return cmds.get(name);
    }

    public static Collection<Command> getCommands() {
        return cmds.values();
    }
}
