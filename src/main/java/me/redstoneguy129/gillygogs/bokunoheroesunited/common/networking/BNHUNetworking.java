package me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking;

import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.client.CQuirkKeyUsage;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.client.CQuirkToggle;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.server.SQuirkKeyUsage;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.server.SQuirkToggle;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class BNHUNetworking {

    public static SimpleChannel instance;
    private static int ID = 0;

    public static int NextID() {
        return ID++;
    }

    public static void registerMessages() {
        instance = NetworkRegistry.newSimpleChannel(new ResourceLocation(BokuNoHeroesUnited.MOD_ID, "networking"), () -> "1.0", s -> true, s -> true);
        instance.registerMessage(NextID(), CQuirkKeyUsage.class, CQuirkKeyUsage::toBytes, CQuirkKeyUsage::new, CQuirkKeyUsage::handle);
        instance.registerMessage(NextID(), SQuirkKeyUsage.class, SQuirkKeyUsage::toBytes, SQuirkKeyUsage::new, SQuirkKeyUsage::handle);
        instance.registerMessage(NextID(), CQuirkToggle.class, CQuirkToggle::toBytes, CQuirkToggle::new, CQuirkToggle::handle);
        instance.registerMessage(NextID(), SQuirkToggle.class, SQuirkToggle::toBytes, SQuirkToggle::new, SQuirkToggle::handle);
    }

}
