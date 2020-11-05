package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.LogicalSide;

import java.util.Map;

public class Quirk {
    public boolean activated = false;

    public String getName() {
        return null;
    }

    public void onActivated(PlayerEntity playerEntity) {}

    public void onDeactivated(PlayerEntity playerEntity) {}

    public void onUpdate(PlayerEntity playerEntity) {}

    public void firstKey(PlayerEntity playerEntity, LogicalSide side) {}

    public void secondKey(PlayerEntity playerEntity, LogicalSide side) {}

    public void thirdKey(PlayerEntity playerEntity, LogicalSide side) {}

    public void fourthKey(PlayerEntity playerEntity, LogicalSide side) {}

    public void fifthKey(PlayerEntity playerEntity, LogicalSide side) {}

    public Map<IAttribute, Double> setAttributes(PlayerEntity playerEntity, Map<IAttribute, Double> map) {
        return map;
    }

    @OnlyIn(Dist.CLIENT)
    public void renderLayer(AbstractClientPlayerEntity player, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {}

    @OnlyIn(Dist.CLIENT)
    public boolean shouldRenderLayer() {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public void renderModel(RenderPlayerEvent.Pre event) {}

    @OnlyIn(Dist.CLIENT)
    public boolean shouldRenderModel() {
        return false;
    }
}
