package me.redstoneguy129.gillygogs.bokunoheroesunited.common.events;

import me.redstoneguy129.gillygogs.bokunoheroesunited.client.BNHUKeyBinds;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.LogicalSide;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class BNHUQuirkKeyEvent extends Event {
    public static enum Keys {
        ONE(BNHUKeyBinds.KEY_1.getKey().getKeyCode(), BNHUKeyBinds.KEY_1),
        TWO(BNHUKeyBinds.KEY_2.getKey().getKeyCode(), BNHUKeyBinds.KEY_2),
        THREE(BNHUKeyBinds.KEY_3.getKey().getKeyCode(), BNHUKeyBinds.KEY_3),
        FOUR(BNHUKeyBinds.KEY_4.getKey().getKeyCode(), BNHUKeyBinds.KEY_4),
        FIVE(BNHUKeyBinds.KEY_5.getKey().getKeyCode(), BNHUKeyBinds.KEY_5);

        private final int key;
        private final KeyBinding keyBinding;

        Keys(int key, KeyBinding keyBinding) {
            this.key = key;
            this.keyBinding = keyBinding;
        }

        public int getKey() {
            return this.key;
        }

        public KeyBinding getKeyBinding() {
            return this.keyBinding;
        }

        public static Keys findKey(int key) {
            if(key == ONE.getKey()) {
                return ONE;
            } else if(key == TWO.getKey()) {
                return TWO;
            } else if(key == THREE.getKey()) {
                return THREE;
            } else if(key == FOUR.getKey()) {
                return FOUR;
            } else if(key == FIVE.getKey()) {
                return FIVE;
            }
            return null;
        }
    }

    private final PlayerEntity playerEntity;
    private final Keys key;
    private final LogicalSide side;

    public BNHUQuirkKeyEvent(PlayerEntity playerEntity, int key) {
        this.playerEntity = playerEntity;
        this.key = Keys.findKey(key);
        if(playerEntity.world.isRemote) {
            this.side = LogicalSide.CLIENT;
        } else {
            this.side = LogicalSide.SERVER;
        }
    }

    public PlayerEntity getPlayerEntity() {
        return this.playerEntity;
    }

    public Keys getKey() {
        return this.key;
    }

    public LogicalSide getSide() {
        return side;
    }
}
