package me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.server;

import io.netty.buffer.ByteBuf;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.BNHUNetworking;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.client.CQuirkToggle;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SQuirkToggle {

    public SQuirkToggle() {}

    public SQuirkToggle(ByteBuf buf) {}

    public void toBytes(ByteBuf buf) {}

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null) {
                player.getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
                    if(playerCapability.getQuirk() != null) playerCapability.getQuirk().activated = !playerCapability.getQuirk().activated;
                });
                BNHUNetworking.instance.sendTo(new CQuirkToggle(), player.connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
            }
        });
        ctx.get().setPacketHandled(true);
    }

}
