package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.quirks;

import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;
import net.minecraft.entity.player.PlayerEntity;

public class QuirklessQuirk extends Quirk {

    @Override
    public String getName() {
        return "quirkless";
    }

    @Override
    public void onUpdate(PlayerEntity playerEntity) {
        System.out.println("Lol your Useless!");
    }
}
