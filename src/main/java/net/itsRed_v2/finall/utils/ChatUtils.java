package net.itsRed_v2.finall.utils;

import net.itsRed_v2.finall.FinallClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;

public enum ChatUtils {
    ;

    private static final String PREFIX = "§3Finall §7§l» §f";
    private static final String ERROR_PREFIX = "§6[§cERROR§6] §f";

    public static void message(String message) {
        ChatHud chatHud = FinallClient.MC.inGameHud.getChatHud();
        chatHud.addMessage(Text.of(PREFIX + message));
    }

    public static void error(String message) {
        message(ERROR_PREFIX + message);
    }
}
