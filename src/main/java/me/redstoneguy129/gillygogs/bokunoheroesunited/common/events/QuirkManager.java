package me.redstoneguy129.gillygogs.bokunoheroesunited.common.events;

import me.redstoneguy129.gillygogs.bokunoheroesunited.common.registry.quirk.Quirks;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class QuirkManager {

    @SubscribeEvent
    public void input(InputEvent.KeyInputEvent event) {
        Quirks.quirkHashMap.get(0).FirstKey(Minecraft.getInstance().player);
    }
}
