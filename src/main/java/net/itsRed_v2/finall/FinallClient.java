package net.itsRed_v2.finall;

import net.fabricmc.api.ModInitializer;
import net.itsRed_v2.finall.command.CommandProcessor;
import net.itsRed_v2.finall.event.EventManager;
import net.itsRed_v2.finall.events.ChatOutputListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinallClient implements ModInitializer {
	
	public static final String MOD_ID = "finall";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final EventManager eventManager = new EventManager();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		eventManager.addListener(ChatOutputListener.class, new CommandProcessor());
	}

	public static EventManager getEventManager() {
		return eventManager;
	}
}
