package me.redstoneguy129.gillygogs.bokunoheroesunited.common.objects;

import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.objects.quirks.DarkShadowQuirk;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class BNHUQuirks {
    public static final DeferredRegister<Quirk> REGISTERS = DeferredRegister.create(Quirk.QUIRK, BokuNoHeroesUnited.MOD_ID);

    public static final RegistryObject<Quirk> QUIRKLESS = REGISTERS.register("quirkless", Quirk::new);
    public static final RegistryObject<Quirk> DARK_SHADOW = REGISTERS.register("dark_shadow", DarkShadowQuirk::new);
}
