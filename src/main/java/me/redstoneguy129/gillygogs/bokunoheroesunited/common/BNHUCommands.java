package me.redstoneguy129.gillygogs.bokunoheroesunited.common;

import com.mojang.brigadier.CommandDispatcher;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.ServerPlayerEntity;

public class BNHUCommands {
    public void register(CommandDispatcher<CommandSource> dispatcher) {
        System.out.println("Registered Command");
    }

    private int setQuirk(CommandSource commandSource, ServerPlayerEntity playerEntity, Quirk quirk) {
        playerEntity.getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
            if(playerCapability.getQuirk() != null) playerCapability.setQuirk(quirk);
        });
        return 1;
    }
}
