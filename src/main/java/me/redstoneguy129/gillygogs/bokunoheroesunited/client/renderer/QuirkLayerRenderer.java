package me.redstoneguy129.gillygogs.bokunoheroesunited.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities.PlayerCapabilityProvider;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;

import javax.annotation.Nonnull;

public class QuirkLayerRenderer extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {

    public PlayerRenderer playerRenderer;

    public QuirkLayerRenderer(PlayerRenderer playerRenderer) {
        super(playerRenderer);
        this.playerRenderer = playerRenderer;
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, @Nonnull IRenderTypeBuffer buffer, int packedLight, AbstractClientPlayerEntity player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        player.getCapability(PlayerCapabilityProvider.CAPABILITY).ifPresent(playerCapability -> {
            if(playerCapability.getQuirk() != null && playerCapability.getQuirk().shouldRenderLayer()) playerCapability.getQuirk().renderLayer(player, matrixStack, buffer, packedLight, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
        });
    }
}
