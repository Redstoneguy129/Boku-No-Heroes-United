package me.redstoneguy129.gillygogs.bokunoheroesunited.common.registry.quirk;

import com.mojang.blaze3d.matrix.MatrixStack;
import me.redstoneguy129.gillygogs.bokunoheroesunited.api.annotation.Quirk;
import me.redstoneguy129.gillygogs.bokunoheroesunited.api.interfaces.IQuirk;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.player.PlayerEntity;

@Quirk(name = "Dark Shadow", id = 1)
public class DarkShadowQuirk extends ModQuirk {
    @Override
    public void Ambience(PlayerEntity playerEntity) {

    }
}
