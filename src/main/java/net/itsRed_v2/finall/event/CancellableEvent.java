package net.itsRed_v2.finall.event;

public abstract class CancellableEvent<T extends Listener> extends Event<T> {

    private boolean cancelled;

    public void cancel() {
        cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }
}
