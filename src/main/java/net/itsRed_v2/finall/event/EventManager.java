package net.itsRed_v2.finall.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.itsRed_v2.finall.FinallClient;

public class EventManager {

    private final Map<Class<? extends Listener>, ArrayList<? extends Listener>> listenerMap = new HashMap<>();

    public static <T extends Listener, E extends Event<T>> void fire(E event) {
        FinallClient.getEventManager().fireImpl(event);
    }

    public <T extends Listener, E extends Event<T>> void fireImpl(E event) {

        @SuppressWarnings("unchecked")
        ArrayList<T> listeners = (ArrayList<T>) listenerMap.get(event.getListenerType());

        if (listeners == null)
            return;

        event.fire(listeners);
    }

    public <L extends Listener> void addListener(Class<L> type , L listener) {

        @SuppressWarnings("unchecked")
        ArrayList<L> listeners = (ArrayList<L>) listenerMap.get(type);

        if (listeners == null) {
            listeners = new ArrayList<>(List.of(listener));
            listenerMap.put(type, listeners);
            return;
        }

        listeners.add(listener);

    }

}
