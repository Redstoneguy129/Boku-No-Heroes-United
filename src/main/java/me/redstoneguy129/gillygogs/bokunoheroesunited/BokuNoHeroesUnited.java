package me.redstoneguy129.gillygogs.bokunoheroesunited;

import me.redstoneguy129.gillygogs.bokunoheroesunited.client.BNHUKeyBinds;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.BNHUCommands;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.CapabilityEvents;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.IPlayerCapability;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapability;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityStorage;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.BNHUNetworking;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.objects.BNHUQuirks;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.QuirkEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BokuNoHeroesUnited.MOD_ID)
public class BokuNoHeroesUnited {
    public static final String MOD_ID = "boku-no-heroes-united";

    public BokuNoHeroesUnited() {
        this.registerObjects(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.addListener(this::serverSetup);
        MinecraftForge.EVENT_BUS.register(new QuirkEvents());
        MinecraftForge.EVENT_BUS.register(new BNHUKeyBinds());
        MinecraftForge.EVENT_BUS.register(new CapabilityEvents());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(IPlayerCapability.class, new PlayerCapabilityStorage(), PlayerCapability::new);
        BNHUNetworking.registerMessages();
    }

    private void serverSetup(final FMLServerStartingEvent event) {
        new BNHUCommands().register(event.getCommandDispatcher());
    }

    private void registerObjects(IEventBus eventBus) {
        BNHUQuirks.REGISTERS.register(eventBus);
    }
}
