package net.itsRed_v2.finall.mixin;

import net.itsRed_v2.finall.FinallClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

	@Inject(at = @At("HEAD"), method = "sendChatMessage(Ljava/lang/String;)V")
	private void onSendMessage(String message, CallbackInfo info) {
		FinallClient.LOGGER.info("Chat output: " + message);
	}
}
