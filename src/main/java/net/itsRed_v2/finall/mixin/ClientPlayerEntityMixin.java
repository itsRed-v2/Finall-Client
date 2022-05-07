package net.itsRed_v2.finall.mixin;

import net.itsRed_v2.finall.event.EventManager;
import net.itsRed_v2.finall.events.ChatOutputListener.ChatOutputEvent;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

	@Inject(method = "sendChatMessage(Ljava/lang/String;)V",
			at = @At("HEAD"),
			cancellable = true)
	private void onSendMessage(String message, CallbackInfo info) {
		ChatOutputEvent event = new ChatOutputEvent(message);
		EventManager.fire(event);

		if (event.isCancelled())
			info.cancel();

	}
}
