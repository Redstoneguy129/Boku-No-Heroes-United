package me.redstoneguy129.gillygogs.bokunoheroesunited.client;

import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.BNHUNetworking;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.SQuirkActivate;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.networking.SQuirkKeyUsage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class BNHUKeyBinds {

    private static final String CATEGORY = "key.categories."+ BokuNoHeroesUnited.MOD_ID;

    public static final KeyBinding KEY_1 = new KeyBinding(BokuNoHeroesUnited.MOD_ID+".key.1", GLFW.GLFW_KEY_Z, CATEGORY);
    public static final KeyBinding KEY_2 = new KeyBinding(BokuNoHeroesUnited.MOD_ID+".key.2", GLFW.GLFW_KEY_R, CATEGORY);
    public static final KeyBinding KEY_3 = new KeyBinding(BokuNoHeroesUnited.MOD_ID+".key.3", GLFW.GLFW_KEY_G, CATEGORY);
    public static final KeyBinding KEY_4 = new KeyBinding(BokuNoHeroesUnited.MOD_ID+".key.4", GLFW.GLFW_KEY_V, CATEGORY);
    public static final KeyBinding KEY_5 = new KeyBinding(BokuNoHeroesUnited.MOD_ID+".key.5", GLFW.GLFW_KEY_B, CATEGORY);

    public static final KeyBinding ACTIVATE = new KeyBinding(BokuNoHeroesUnited.MOD_ID+".key.activate", GLFW.GLFW_KEY_X, CATEGORY);
    public static final KeyBinding DEACTIVATE = new KeyBinding(BokuNoHeroesUnited.MOD_ID+".key.deactivate", GLFW.GLFW_KEY_C, CATEGORY);

    static {
        ClientRegistry.registerKeyBinding(KEY_1);
        ClientRegistry.registerKeyBinding(KEY_2);
        ClientRegistry.registerKeyBinding(KEY_3);
        ClientRegistry.registerKeyBinding(KEY_4);
        ClientRegistry.registerKeyBinding(KEY_5);
        ClientRegistry.registerKeyBinding(ACTIVATE);
        ClientRegistry.registerKeyBinding(DEACTIVATE);
    }

    @SubscribeEvent
    public void keyInput(InputEvent.KeyInputEvent event) {
        if(KEY_1.isPressed()) {
            BNHUNetworking.instance.sendToServer(new SQuirkKeyUsage(KEY_1.getKey().getKeyCode()));
        } else if(KEY_2.isPressed()) {
            BNHUNetworking.instance.sendToServer(new SQuirkKeyUsage(KEY_2.getKey().getKeyCode()));
        } else if(KEY_3.isPressed()) {
            BNHUNetworking.instance.sendToServer(new SQuirkKeyUsage(KEY_3.getKey().getKeyCode()));
        } else if(KEY_4.isPressed()) {
            BNHUNetworking.instance.sendToServer(new SQuirkKeyUsage(KEY_4.getKey().getKeyCode()));
        } else if(KEY_5.isPressed()) {
            BNHUNetworking.instance.sendToServer(new SQuirkKeyUsage(KEY_5.getKey().getKeyCode()));
        } else if(ACTIVATE.isPressed()) {
            BNHUNetworking.instance.sendToServer(new SQuirkActivate(true));
        } else if(DEACTIVATE.isPressed()) {
            BNHUNetworking.instance.sendToServer(new SQuirkActivate(false));
        }
    }

}
