package me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.server;

import io.netty.buffer.ByteBuf;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.events.BNHUQuirkKeyEvent;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.BNHUNetworking;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.client.CQuirkKeyUsage;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SQuirkKeyUsage {

    public int key;

    public SQuirkKeyUsage(int key) {
        this.key = key;
    }

    public SQuirkKeyUsage(ByteBuf buf) {
        this.key = buf.readInt();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.key);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null) {
                MinecraftForge.EVENT_BUS.post(new BNHUQuirkKeyEvent(player, this.key));
                BNHUNetworking.instance.sendTo(new CQuirkKeyUsage(this.key), player.connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
            }
        });
        ctx.get().setPacketHandled(true);
    }

}
