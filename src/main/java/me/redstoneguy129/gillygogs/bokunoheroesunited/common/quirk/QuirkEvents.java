package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk;

import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import me.redstoneguy129.gillygogs.bokunoheroesunited.client.renderer.QuirkLayerRenderer;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.events.BNHUQuirkKeyEvent;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.*;

public class QuirkEvents {

    private final Map<PlayerEntity, AttributeModifier[]> playerModifiedMap = new HashMap<>();

    @SuppressWarnings("SuspiciousMethodCalls")
    @SubscribeEvent
    public void updateEvent(LivingEvent.LivingUpdateEvent event) {
        if(event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) event.getEntityLiving();
            playerEntity.getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
                if(playerCapability.getQuirk() != null) {
                    if(playerCapability.getQuirk().activated) {
                        Map<IAttribute, Double> map = playerCapability.getQuirk().setAttributes(playerEntity, new HashMap<>());
                        if(playerModifiedMap.containsKey(playerEntity)) {
                            Arrays.asList(playerModifiedMap.get(playerEntity)).forEach(attributeModifier -> playerEntity.getAttributes().getAllAttributes().forEach(iAttributeInstance -> {
                                if(iAttributeInstance.hasModifier(attributeModifier))
                                    iAttributeInstance.removeModifier(attributeModifier);
                            }));
                        }
                        map.forEach((iAttribute, aDouble) -> {
                            AttributeModifier attributeModifier = new AttributeModifier(playerEntity.getUniqueID(),
                                    iAttribute.getName()+"."+BokuNoHeroesUnited.MOD_ID,
                                    aDouble,
                                    AttributeModifier.Operation.MULTIPLY_TOTAL);
                            if(!playerEntity.getAttribute(iAttribute).hasModifier(attributeModifier)) playerEntity.getAttribute(iAttribute).applyModifier(attributeModifier);
                            if(playerModifiedMap.containsKey(playerEntity)) {
                                List<AttributeModifier> attributeModifierList = Arrays.asList(playerModifiedMap.get(playerEntity));
                                attributeModifierList.add(attributeModifier);
                                if(attributeModifierList.toArray() instanceof AttributeModifier[]) playerModifiedMap.put(playerEntity, (AttributeModifier[]) attributeModifierList.toArray());
                            } else {
                                if(Collections.singletonList(attributeModifier).toArray() instanceof AttributeModifier[]) playerModifiedMap.put(playerEntity, (AttributeModifier[]) Collections.singletonList(attributeModifier).toArray());
                            }
                        });
                        playerCapability.getQuirk().onUpdate(playerEntity);
                    } else {
                        if(playerModifiedMap.containsKey(playerEntity)) {
                            Arrays.asList(playerModifiedMap.get(playerEntity)).forEach(attributeModifier -> playerEntity.getAttributes().getAllAttributes().forEach(iAttributeInstance -> {
                                if(iAttributeInstance.hasModifier(attributeModifier))
                                    iAttributeInstance.removeModifier(attributeModifier);
                            }));
                        }
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public void keyEvent(BNHUQuirkKeyEvent event) {
        event.getPlayerEntity().getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
            if(playerCapability.getQuirk() != null && playerCapability.getQuirk().activated) {
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
