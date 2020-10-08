package me.redstoneguy129.gillygogs.bokunoheroesunited.common.events;

import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capability.IQuirkCapability;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capability.QuirkProvider;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.registry.quirk.Quirks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class CapabilityEvent {

    private final Random random = new Random();

    @SubscribeEvent
    public void onClone(PlayerEvent.Clone event) {
        if(event.getOriginal().getCapability(QuirkProvider.CAPABILITY).isPresent()) {
            IQuirkCapability Old = (IQuirkCapability) event.getOriginal().getCapability(QuirkProvider.CAPABILITY);
            IQuirkCapability New = (IQuirkCapability) event.getPlayer().getCapability(QuirkProvider.CAPABILITY);
            New.Copy(Old);
        }
    }

    @SubscribeEvent
    public void giveQuirk(PlayerEvent.PlayerLoggedInEvent event) {
        event.getPlayer().getCapability(QuirkProvider.CAPABILITY).ifPresent(quirk -> {
            if(quirk.getQuirk() == -1) {
                quirk.setQuirk(random.nextInt(Quirks.quirkHashMap.size()));
            }
        });
    }

    @SubscribeEvent
    public void onAttachCapability(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof PlayerEntity)
            event.addCapability(new ResourceLocation(BokuNoHeroesUnited.MOD_ID, "quirk"), new QuirkProvider());
    }

}
