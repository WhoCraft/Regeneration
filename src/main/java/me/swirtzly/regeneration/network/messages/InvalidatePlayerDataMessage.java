package me.swirtzly.regeneration.network.messages;

import me.swirtzly.regeneration.client.skinhandling.SkinManipulation;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * Created by Craig on 20/09/2018.
 */
public class InvalidatePlayerDataMessage {

    private UUID playerUUID;

    public InvalidatePlayerDataMessage(UUID uuid) {
        this.playerUUID = uuid;
    }

    public static void encode(InvalidatePlayerDataMessage invalidatePlayerDataMessage, PacketBuffer buffer) {
        buffer.writeUUID(invalidatePlayerDataMessage.playerUUID);
    }

    public static InvalidatePlayerDataMessage decode(PacketBuffer buffer) {
        return new InvalidatePlayerDataMessage(buffer.readUUID());
    }

    public static class Handler {
        public static void handle(InvalidatePlayerDataMessage message, Supplier<NetworkEvent.Context> ctx) {
            Minecraft.getInstance().submitAsync(() -> SkinManipulation.PLAYER_SKINS.remove(message.playerUUID));
            ctx.get().setPacketHandled(true);
        }
    }
}
