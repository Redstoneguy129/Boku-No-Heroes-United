package me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking;

import io.netty.buffer.ByteBuf;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SQuirkActivate {

    public boolean activate;

    public SQuirkActivate(boolean activate) {
        this.activate = activate;
    }

    public SQuirkActivate(ByteBuf buf) {
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
                BNHUNetworking.instance.sendTo(new CQuirkActivate(this.activate), player.connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
            }
        });
        ctx.get().setPacketHandled(true);
    }

}
