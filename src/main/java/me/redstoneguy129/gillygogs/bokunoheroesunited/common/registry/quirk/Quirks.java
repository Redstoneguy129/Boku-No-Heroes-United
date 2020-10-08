package me.redstoneguy129.gillygogs.bokunoheroesunited.common.registry.quirk;

import me.redstoneguy129.gillygogs.bokunoheroesunited.api.annotation.Quirk;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;

public class Quirks {
    public static HashMap<Integer, ModQuirk> quirkHashMap = new HashMap<>();

    public static void registerQuirks(RegistryEvent.NewRegistry event) {
        Set<Class<?>> quirkList = new Reflections("me.redstoneguy129.gillygogs.bokunoheroesunited.common.registry.quirk", new TypeAnnotationsScanner(), new SubTypesScanner()).getTypesAnnotatedWith(Quirk.class);
        quirkList.forEach(quirkClass -> {
            try {
                ModQuirk quirk = (ModQuirk) quirkClass.getDeclaredConstructor().newInstance();
                Quirk AQuirk = quirkClass.getAnnotation(Quirk.class);
                MinecraftForge.EVENT_BUS.register(quirk);
                quirkHashMap.put(AQuirk.id(), quirk);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

}
