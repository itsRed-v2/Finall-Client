package net.itsRed_v2.finall.command;

import net.itsRed_v2.finall.FinallClient;
import net.itsRed_v2.finall.events.ChatOutputListener;

public class CommandProcessor implements ChatOutputListener {

    public static final String PREFIX = "$";

    @Override
    public void onChatOutput(ChatOutputEvent event) {

        String message = event.getMessage();

        if (message.startsWith(PREFIX)) {
            FinallClient.LOGGER.info("Command: " + message.substring(PREFIX.length()));
            event.cancel();
        }
    }
}
