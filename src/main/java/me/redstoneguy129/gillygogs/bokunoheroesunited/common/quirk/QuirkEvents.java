package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk;

import me.redstoneguy129.gillygogs.bokunoheroesunited.client.renderer.QuirkLayerRenderer;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.events.BNHUQuirkKeyEvent;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class QuirkEvents {

    @SubscribeEvent
    public void updateEvent(LivingEvent.LivingUpdateEvent event) {
        if(event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) event.getEntityLiving();
            playerEntity.getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
                if(playerCapability.getQuirk() != null) playerCapability.getQuirk().onUpdate(playerEntity);
            });
        }
    }

    @SubscribeEvent
    public void keyEvent(BNHUQuirkKeyEvent event) {
        event.getPlayerEntity().getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
            if(playerCapability.getQuirk() != null) {
                switch (event.getKey()) {
                    case ONE:
                        playerCapability.getQuirk().firstKey(event.getPlayerEntity(), event.getSide());
                        break;
                    case TWO:
                        playerCapability.getQuirk().secondKey(event.getPlayerEntity(), event.getSide());
                        break;
                    case THREE:
                        playerCapability.getQuirk().thirdKey(event.getPlayerEntity(), event.getSide());
                        break;
                    case FOUR:
                        playerCapability.getQuirk().fourthKey(event.getPlayerEntity(), event.getSide());
                        break;
                    case FIVE:
                        playerCapability.getQuirk().fifthKey(event.getPlayerEntity(), event.getSide());
                        break;
                }
            }
        });
    }

    private final List<PlayerRenderer> playerRendererList = new ArrayList<>();

    @SubscribeEvent
    public void render(RenderPlayerEvent.Pre event) {
        event.getPlayer().getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
            if(playerCapability.getQuirk() != null && playerCapability.getQuirk().shouldRenderModel()) {
                event.setCanceled(true);
                playerCapability.getQuirk().renderModel(event);
            }
        });
        if(playerRendererList.contains(event.getRenderer())) return;
        event.getRenderer().addLayer(new QuirkLayerRenderer(event.getRenderer()));
        playerRendererList.add(event.getRenderer());
    }

}
