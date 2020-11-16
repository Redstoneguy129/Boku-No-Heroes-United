package me.redstoneguy129.gillygogs.bokunoheroesunited.common.events;

import me.redstoneguy129.gillygogs.bokunoheroesunited.client.BNHUKeyBinds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.LogicalSide;

public class BNHUQuirkKeyEvent extends Event {

    private final PlayerEntity playerEntity;
    private final BNHUKeyBinds.Keys key;
    private final LogicalSide side;

    public BNHUQuirkKeyEvent(PlayerEntity playerEntity, BNHUKeyBinds.Keys key) {
        this.playerEntity = playerEntity;
        this.key = key;
        if(playerEntity.world.isRemote) {
            this.side = LogicalSide.CLIENT;
        } else {
            this.side = LogicalSide.SERVER;
        }
    }

    public PlayerEntity getPlayerEntity() {
        return this.playerEntity;
    }

    public BNHUKeyBinds.Keys getKey() {
        return this.key;
    }

    public LogicalSide getSide() {
        return side;
    }
}
