package de.maxhenkel.voicechat.voice.common;

import net.minecraft.network.FriendlyByteBuf;

public class ConnectionCheckAckPacket implements Packet<ConnectionCheckAckPacket> {

    public ConnectionCheckAckPacket() {

    }

    @Override
    public ConnectionCheckAckPacket fromBytes(FriendlyByteBuf buf) {
        return new ConnectionCheckAckPacket();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {

    }
}
