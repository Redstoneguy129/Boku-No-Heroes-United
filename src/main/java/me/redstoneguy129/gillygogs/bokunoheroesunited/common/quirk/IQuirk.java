package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.LogicalSide;

public interface IQuirk {

    default void onActivated(PlayerEntity playerEntity) {}

    default void onDeactivated(PlayerEntity playerEntity) {}

    default void onUpdate(PlayerEntity playerEntity) {}

    default void firstKey(PlayerEntity playerEntity, LogicalSide side) {}

    default void secondKey(PlayerEntity playerEntity, LogicalSide side) {}

    default void thirdKey(PlayerEntity playerEntity, LogicalSide side) {}

    default void fourthKey(PlayerEntity playerEntity, LogicalSide side) {}

    default void fifthKey(PlayerEntity playerEntity, LogicalSide side) {}

    @OnlyIn(Dist.CLIENT)
    default void renderLayer(AbstractClientPlayerEntity player, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {}

    default boolean shouldRenderLayer() {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    default void renderModel() {}

    default boolean shouldRenderModel() {
        return false;
    }
}
