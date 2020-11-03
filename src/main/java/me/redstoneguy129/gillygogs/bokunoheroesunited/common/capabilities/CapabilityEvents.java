package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities;

import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityEvents {

    @SubscribeEvent
    public void onAttachCapability(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(BokuNoHeroesUnited.MOD_ID, "quirk"), new PlayerCapabilityProvider());
        }
    }

    @SubscribeEvent
    public void onClone(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent((oldPlayerCapability -> {
            ((IPlayerCapability) event.getPlayer().getCapability(PlayerCapabilityProvider.CAPABILITY)).copy(oldPlayerCapability);
        }));
    }

}