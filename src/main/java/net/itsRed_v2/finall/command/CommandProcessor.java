package net.itsRed_v2.finall.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.itsRed_v2.finall.events.ChatOutputListener;
import net.itsRed_v2.finall.utils.ChatUtils;
import org.jetbrains.annotations.NotNull;

public class CommandProcessor implements ChatOutputListener {

    public static final String PREFIX = ":";

    @Override
    public void onChatOutput(ChatOutputEvent event) {

        String message = event.getMessage();

        if (message.startsWith(PREFIX)) {
            event.cancel();

            List<String> args = new ArrayList<>();
            Collections.addAll(args, message.substring(PREFIX.length()).split(" "));
            String name = args.remove(0);

            Command cmd = CommandList.getByName(name);

            if (cmd == null) {
                ChatUtils.error("§cUnknown command: §6" + name);
                return;
            }

            process(cmd, args);
        }
    }

    private void process(@NotNull Command cmd, @NotNull List<String> args) {
        try {
            cmd.run(args);
        } catch (CommandSyntaxError error) {
            ChatUtils.error("§cSyntax error: " + error.getMessage());
            ChatUtils.message("§cCorrext syntax:");
            cmd.sendSyntax();
        }
    }
}
