package me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking;

import io.netty.buffer.ByteBuf;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.events.BNHUQuirkKeyEvent;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class CQuirkKeyUsage {

    public int key;

    public CQuirkKeyUsage(int key) {
        this.key = key;
    }

    public CQuirkKeyUsage(ByteBuf buf) {
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
            }
        });
        ctx.get().setPacketHandled(true);
    }

}
