package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.quirks;

import com.mojang.blaze3d.matrix.MatrixStack;
import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import me.redstoneguy129.gillygogs.bokunoheroesunited.client.models.DarkShadowModel;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.LogicalSide;

public class DarkShadowQuirk extends Quirk {
    private boolean active = false;

    private double defaultMaxHealth;
    private double defaultAttackDamage;

    @Override
    public void onActivated(PlayerEntity playerEntity) {
        defaultAttackDamage = playerEntity.getAttributes().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE).getBaseValue();
        defaultMaxHealth = playerEntity.getAttributes().getAttributeInstance(SharedMonsterAttributes.MAX_HEALTH).getBaseValue();
        this.active = true;
    }

    @Override
    public void onDeactivated(PlayerEntity playerEntity) {
        this.active = false;
        playerEntity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(defaultMaxHealth);
        playerEntity.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(defaultAttackDamage);
    }

    @Override
    public void onUpdate(PlayerEntity playerEntity) {
        if(!active) return;
        if(playerEntity.world.isNightTime()) {
            playerEntity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40D);
            playerEntity.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
        } else {
            playerEntity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25D);
            playerEntity.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
        }
    }

    @Override
    public boolean shouldRenderLayer() {
        return this.active;
    }

    @Override
    public void renderModel(RenderPlayerEvent.Pre event) {

    }

    @Override
    public boolean shouldRenderModel() {
        return false;
    }

    @Override
    public void renderLayer(AbstractClientPlayerEntity player, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        DarkShadowModel darkShadowModel = new DarkShadowModel();
        ResourceLocation darkShadowTexture = new ResourceLocation(BokuNoHeroesUnited.MOD_ID, "textures/layer/dark_shadow.png");
        darkShadowModel.render(matrixStack, buffer.getBuffer(RenderType.getEntityTranslucent(darkShadowTexture)), packedLight, OverlayTexture.NO_OVERLAY, 1F, 1F, 1F, 1F);
    }
}
