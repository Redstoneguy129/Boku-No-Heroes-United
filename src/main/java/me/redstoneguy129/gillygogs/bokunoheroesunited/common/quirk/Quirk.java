package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.LogicalSide;

public abstract class Quirk {

    public void onActivated(PlayerEntity playerEntity) {}

    public void onDeactivated(PlayerEntity playerEntity) {}

    public void onUpdate(PlayerEntity playerEntity) {}

    public void firstKey(PlayerEntity playerEntity, LogicalSide side) {}

    public void secondKey(PlayerEntity playerEntity, LogicalSide side) {}

    public void thirdKey(PlayerEntity playerEntity, LogicalSide side) {}

    public void fourthKey(PlayerEntity playerEntity, LogicalSide side) {}

    public void fifthKey(PlayerEntity playerEntity, LogicalSide side) {}

    @OnlyIn(Dist.CLIENT)
    public abstract void renderLayer(AbstractClientPlayerEntity player, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch);

    @OnlyIn(Dist.CLIENT)
    public abstract boolean shouldRenderLayer();

    @OnlyIn(Dist.CLIENT)
    public abstract void renderModel(RenderPlayerEvent.Pre event);

    @OnlyIn(Dist.CLIENT)
    public abstract boolean shouldRenderModel();
}
