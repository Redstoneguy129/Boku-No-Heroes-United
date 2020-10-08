package me.redstoneguy129.gillygogs.bokunoheroesunited;

import me.redstoneguy129.gillygogs.bokunoheroesunited.api.annotation.Quirk;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capability.IQuirkCapability;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capability.QuirkCapabilityCapability;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capability.QuirkStorage;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.events.CapabilityEvent;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.registry.quirk.Quirks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BokuNoHeroesUnited.MOD_ID)
public class BokuNoHeroesUnited {
    public static final String MOD_ID = "boku-no-heroes-united";

    public BokuNoHeroesUnited() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Quirks::registerQuirks);
        MinecraftForge.EVENT_BUS.register(new CapabilityEvent());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(IQuirkCapability.class, new QuirkStorage(), QuirkCapabilityCapability::new);
    }
}
