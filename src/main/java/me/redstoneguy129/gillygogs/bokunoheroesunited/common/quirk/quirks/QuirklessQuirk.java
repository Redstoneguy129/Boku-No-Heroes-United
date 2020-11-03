package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.quirks;

import com.mojang.blaze3d.matrix.MatrixStack;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class QuirklessQuirk extends Quirk {
    @Override
    public void renderLayer(AbstractClientPlayerEntity player, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public boolean shouldRenderLayer() {
        return false;
    }

    @Override
    public void renderModel(RenderPlayerEvent.Pre event) {

    }

    @Override
    public boolean shouldRenderModel() {
        return false;
    }
}
