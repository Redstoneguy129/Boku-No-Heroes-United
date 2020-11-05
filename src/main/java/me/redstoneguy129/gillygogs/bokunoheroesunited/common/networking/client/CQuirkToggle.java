package me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.client;

import io.netty.buffer.ByteBuf;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class CQuirkToggle {

    public CQuirkToggle() {}

    public CQuirkToggle(ByteBuf buf) {}

    public void toBytes(ByteBuf buf) {}

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null) {
                player.getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
                    if(playerCapability.getQuirk() != null) playerCapability.getQuirk().activated = !playerCapability.getQuirk().activated;
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }

}
