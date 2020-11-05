package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.quirks;

import com.mojang.blaze3d.matrix.MatrixStack;
import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import me.redstoneguy129.gillygogs.bokunoheroesunited.client.models.DarkShadowModel;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;

import java.util.Map;

public class DarkShadowQuirk extends Quirk {

    @Override
    public String getName() {
        return "darkshadow";
    }

    @Override
    public Map<IAttribute, Double> setAttributes(PlayerEntity playerEntity, Map<IAttribute, Double> map) {
        if(playerEntity.world.isNightTime()) {
            map.put(SharedMonsterAttributes.ATTACK_DAMAGE, 5D);
        } else {
            map.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, 5D);
            map.put(SharedMonsterAttributes.MAX_HEALTH, 10D);
        }
        return super.setAttributes(playerEntity, map);
    }

    @Override
    public boolean shouldRenderLayer() {
        return this.activated;
    }

    @Override
    public void renderLayer(AbstractClientPlayerEntity player, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        DarkShadowModel darkShadowModel = new DarkShadowModel();
        ResourceLocation darkShadowTexture = new ResourceLocation(BokuNoHeroesUnited.MOD_ID, "textures/layer/dark_shadow.png");
        darkShadowModel.render(matrixStack, buffer.getBuffer(RenderType.getEntityTranslucent(darkShadowTexture)), packedLight, OverlayTexture.NO_OVERLAY, 1F, 1F, 1F, 1F);
    }
}
