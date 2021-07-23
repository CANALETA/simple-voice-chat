package de.maxhenkel.voicechat.gui.widgets;

import de.maxhenkel.voicechat.Main;
import de.maxhenkel.voicechat.voice.common.PlayerState;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

public class AdjustVolumeSlider extends AbstractSliderButton {

    private static final float MAXIMUM = 4F;

    private PlayerState player;

    public AdjustVolumeSlider(int xIn, int yIn, int widthIn, int heightIn, PlayerState player) {
        super(xIn, yIn, widthIn, heightIn, TextComponent.EMPTY, (player == null ? 1D : Main.VOLUME_CONFIG.getVolume(player.getGameProfile().getId(), 1D)) / MAXIMUM);
        this.player = player;
        if (player == null) {
            visible = false;
        }
        updateMessage();
    }

    @Override
    protected void updateMessage() {
        long amp = Math.round(value * MAXIMUM * 100F - 100F);
        setMessage(new TranslatableComponent("message.voicechat.volume_amplification", (amp > 0F ? "+" : "") + amp + "%"));
    }

    @Override
    protected void applyValue() {
        Main.VOLUME_CONFIG.setVolume(player.getGameProfile().getId(), value * MAXIMUM);
    }
}
