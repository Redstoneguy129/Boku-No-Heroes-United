package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk;

import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.quirks.DarkShadowQuirk;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.quirks.QuirklessQuirk;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Mod.EventBusSubscriber(modid = BokuNoHeroesUnited.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class QuirkRegistry {
    private static final Random random = new Random();

    public static final Map<Integer, Quirk> quirkMap = new HashMap<>();
    public static final Map<String, Quirk> quirkStringMap = new HashMap<>();

    public static void registerQuirks() {
        List<Quirk> quirks = new ArrayList<>();
        quirks.add(new QuirklessQuirk());
        quirks.add(new DarkShadowQuirk());
        for(int i = 0; i < quirks.size(); i++) {
            quirkMap.put(i, quirks.get(i));
            quirkStringMap.put(quirks.get(i).getName(), quirks.get(i));
        }
    }

    public static int getQuirkID(Quirk quirk) {
        AtomicInteger i = new AtomicInteger();
        quirkMap.forEach((integer, quirk1) -> {
            if(quirk1.equals(quirk)) i.set(integer);
        });
        return i.get();
    }

    @SubscribeEvent
    public static void GiveQuirk(EntityJoinWorldEvent event) {
        if(!(event.getEntity() instanceof PlayerEntity)) return;
        event.getEntity().getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
            if(!playerCapability.hasLoggedInBefore()) {
                playerCapability.setLoggedInBefore(true);
                playerCapability.setQuirk(quirkMap.get(random.nextInt(quirkMap.size())));
            }
        });
    }
}
