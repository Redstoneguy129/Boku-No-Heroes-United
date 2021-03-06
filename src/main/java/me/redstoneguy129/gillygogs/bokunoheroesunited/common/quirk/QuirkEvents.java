package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk;

import me.redstoneguy129.gillygogs.bokunoheroesunited.client.renderer.QuirkLayerRenderer;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.events.BNHUQuirkKeyEvent;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuirkEvents {

    private final Random random = new Random();

    @SubscribeEvent
    public void GiveQuirk(EntityJoinWorldEvent event) {
        if(!(event.getEntity() instanceof PlayerEntity)) return;
        event.getEntity().getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
            if(!playerCapability.hasLoggedInBefore()) {
                playerCapability.setLoggedInBefore(true);
                playerCapability.setQuirk((Quirk) Quirk.QUIRK.getValues().toArray()[random.nextInt(Quirk.QUIRK.getValues().size())]);
            }
        });
    }

    @SubscribeEvent
    public void updateEvent(LivingEvent.LivingUpdateEvent event) {
        if(event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) event.getEntityLiving();
            playerEntity.getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
                if(playerCapability.getQuirk() != null) {
                    if(playerCapability.getQuirk().activated) {
                        playerCapability.getQuirk().onUpdate(playerEntity);
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public void keyEvent(BNHUQuirkKeyEvent event) {
        event.getPlayerEntity().getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
            if(playerCapability.getQuirk() != null && playerCapability.getQuirk().activated) {
                playerCapability.getQuirk().keyUsage(event.getPlayerEntity(), event.getKey(), event.getSide());
            }
        });
    }

    private final List<PlayerRenderer> playerRendererList = new ArrayList<>();

    @SubscribeEvent
    public void render(RenderPlayerEvent.Pre event) {
        event.getPlayer().getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
            if(playerCapability.getQuirk() != null) {
                event.setCanceled(true);
                playerCapability.getQuirk().renderModel(event);
            }
        });
        if(playerRendererList.contains(event.getRenderer())) return;
        event.getRenderer().addLayer(new QuirkLayerRenderer(event.getRenderer()));
        playerRendererList.add(event.getRenderer());
    }

}
