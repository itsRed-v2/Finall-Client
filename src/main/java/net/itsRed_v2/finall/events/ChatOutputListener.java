package net.itsRed_v2.finall.events;

import java.util.ArrayList;

import net.itsRed_v2.finall.event.CancellableEvent;
import net.itsRed_v2.finall.event.Listener;

public interface ChatOutputListener extends Listener {

    void onChatOutput(ChatOutputEvent event);

    class ChatOutputEvent extends CancellableEvent<ChatOutputListener> {

        private final String message;

        public ChatOutputEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public void fire(ArrayList<ChatOutputListener> listeners) {
            for (ChatOutputListener listener : listeners)
                listener.onChatOutput(this);
        }

        @Override
        public Class<ChatOutputListener> getListenerType() {
            return ChatOutputListener.class;
        }
    }
}
