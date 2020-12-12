package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk;

import com.mojang.blaze3d.matrix.MatrixStack;
import me.redstoneguy129.gillygogs.bokunoheroesunited.BokuNoHeroesUnited;
import me.redstoneguy129.gillygogs.bokunoheroesunited.client.BNHUKeyBinds;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.UUID;

public class Quirk extends ForgeRegistryEntry<Quirk> {
    public static final IForgeRegistry<Quirk> QUIRK = new RegistryBuilder<Quirk>().setIDRange(0, 2048).setType(Quirk.class).setName(new ResourceLocation(BokuNoHeroesUnited.MOD_ID, "quirk")).create();

    public boolean activated = false;
    public final QuirkType quirkType;

    public Quirk(QuirkType quirkType) {
        this.quirkType = quirkType;
    }

    public Quirk() {
        this.quirkType = QuirkType.EMITTER;
    }

    public void onActivated(PlayerEntity playerEntity) {}

    public void onDeactivated(PlayerEntity playerEntity) {}

    public void onUpdate(PlayerEntity playerEntity) {}

    public void keyUsage(PlayerEntity playerEntity, BNHUKeyBinds.Keys key, LogicalSide side) {}

    @OnlyIn(Dist.CLIENT)
    public void renderLayer(AbstractClientPlayerEntity player, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {}

    @OnlyIn(Dist.CLIENT)
    public boolean shouldRenderLayer() {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public void renderModel(RenderPlayerEvent.Pre event) {}

    public final void addAttribute(PlayerEntity entity, Attribute attribute, double value, AttributeModifier.Operation operation, UUID uuid) {
        addAttribute(entity, "bnhudefault", attribute, value, operation, uuid);
    }

    public final void addAttribute(PlayerEntity entity, String name, Attribute attribute, double value, AttributeModifier.Operation operation, UUID uuid) {
        AbstractAttributeMap map = entity.getAttributes();
        if (map.getAttributeInstance(attribute) != null) {
            ModifiableAttributeInstance instance = (ModifiableAttributeInstance) map.getAttributeInstance(attribute);
            if (entity.getAttribute(attribute).getModifier(uuid) == null) {
                AttributeModifier modifier = new AttributeModifier(uuid, name, value, operation);
                instance.applyModifier(modifier);
            }
        }
    }

    public final void setAttribute(PlayerEntity entity, String name, Attribute attribute, UUID uuid, double amount, AttributeModifier.Operation operation) {
        ModifiableAttributeInstance instance = (ModifiableAttributeInstance) entity.getAttribute(attribute);
        if (entity.world.isRemote) return;
        AttributeModifier modifier = instance.getModifier(uuid);
        if (amount == 0 || modifier != null && (modifier.getAmount() != amount || modifier.getOperation() != operation)) {
            instance.removeModifier(uuid);
        }
        modifier = instance.getModifier(uuid);
        if (modifier == null) {
            modifier = new AttributeModifier(uuid, name, amount, operation);
            instance.applyModifier(modifier);
        }
    }

    public final void removeAttribute(PlayerEntity entity, Attribute attribute, UUID uuid) {
        AbstractAttributeMap map = entity.getAttributes();
        if (map.getAttributeInstance(attribute) != null) {
            ModifiableAttributeInstance instance = (ModifiableAttributeInstance) map.getAttributeInstance(attribute);
            if(instance != null) {
                instance.removeModifier(uuid);
            }
        }
    }
}
