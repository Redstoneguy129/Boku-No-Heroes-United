package me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking;

import io.netty.buffer.ByteBuf;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class QuirkTogglePacket {

    public QuirkTogglePacket() {}

    public QuirkTogglePacket(ByteBuf buf) {}

    public void toBytes(ByteBuf buf) {}

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null) {
                player.getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
                    if(playerCapability.getQuirk() != null) {
                        playerCapability.getQuirk().activated = !playerCapability.getQuirk().activated;
                        if(playerCapability.getQuirk().activated)
                            playerCapability.getQuirk().onActivated(player);
                        else playerCapability.getQuirk().onDeactivated(player);
                    }
                });
                if(ctx.get().getDirection().getReceptionSide().isServer())
                    BNHUNetworking.instance.sendTo(new QuirkTogglePacket(), player.connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
            }
        });
        ctx.get().setPacketHandled(true);
    }

}
