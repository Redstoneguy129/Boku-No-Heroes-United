package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.quirks;

import com.mojang.blaze3d.matrix.MatrixStack;
import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import me.redstoneguy129.gillygogs.bokunoheroesunited.client.models.DarkShadowModel;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.IQuirk;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.LogicalSide;

public class DarkShadowQuirk implements IQuirk {
    @Override
    public void onUpdate(PlayerEntity playerEntity) {
        System.out.println("I AM DARK SHADOW");
    }

    @Override
    public void firstKey(PlayerEntity playerEntity, LogicalSide side) {
        System.out.println("First key");
    }

    @Override
    public boolean shouldRenderLayer() {
        return true;
    }

    @Override
    public void renderLayer(AbstractClientPlayerEntity player, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        System.out.println("RENDERING");
        DarkShadowModel darkShadowModel = new DarkShadowModel();
        ResourceLocation darkShadowTexture = new ResourceLocation(BokuNoHeroesUnited.MOD_ID, "textures/layer/dark_shadow.png");
        darkShadowModel.render(matrixStack, buffer.getBuffer(RenderType.getEntityTranslucent(darkShadowTexture)), packedLight, OverlayTexture.NO_OVERLAY, 1F, 1F, 1F, 1F);
    }
}