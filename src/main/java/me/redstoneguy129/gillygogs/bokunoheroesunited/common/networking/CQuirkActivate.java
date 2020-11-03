package me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking;

import io.netty.buffer.ByteBuf;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class CQuirkActivate {

    public boolean activate;

    public CQuirkActivate(boolean activate) {
        this.activate = activate;
    }

    public CQuirkActivate(ByteBuf buf) {
        this.activate = buf.readBoolean();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(this.activate);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null) {
                player.getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
                    if(playerCapability.getQuirk() != null) {
                        if(this.activate) {
                            playerCapability.getQuirk().onActivated(player);
                        } else {
                            playerCapability.getQuirk().onDeactivated(player);
                        }
                    }
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }

}
