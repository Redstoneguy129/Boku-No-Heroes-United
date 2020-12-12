package me.redstoneguy129.gillygogs.bokunoheroesunited.common.objects.quirks;

import com.mojang.blaze3d.matrix.MatrixStack;
import me.redstoneguy129.gillygogs.bokunoheroesunited.client.BNHUKeyBinds;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;
import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.QuirkType;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.LogicalSide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TransferenceQuirk extends Quirk {

    private final List<Quirk> EMITTERS = new ArrayList<>(8);
    private final List<Quirk> TRANSFORMATION = new ArrayList<>(1);
    private final List<Quirk> MUTATION = new ArrayList<>(1);

    public TransferenceQuirk() {
        super(QuirkType.EMITTER);
    }

    public TransferenceQuirk(Quirk... quirks) {
        super(QuirkType.EMITTER);
        Arrays.asList(quirks).forEach(quirk -> {
            switch (quirk.quirkType) {
                case EMITTER:
                    this.EMITTERS.add(quirk);
                    break;
                case MUTANT:
                    this.MUTATION.add(quirk);
                    break;
                case TRANSFORMATION:
                    this.TRANSFORMATION.add(quirk);
            }
        });
    }

    @Override
    public void onActivated(PlayerEntity playerEntity) {
        this.EMITTERS.forEach(quirk -> quirk.onActivated(playerEntity));
        this.TRANSFORMATION.forEach(quirk -> quirk.onActivated(playerEntity));
        this.MUTATION.forEach(quirk -> quirk.onActivated(playerEntity));
    }

    @Override
    public void onDeactivated(PlayerEntity playerEntity) {
        this.EMITTERS.forEach(quirk -> quirk.onDeactivated(playerEntity));
        this.TRANSFORMATION.forEach(quirk -> quirk.onDeactivated(playerEntity));
        this.MUTATION.forEach(quirk -> quirk.onDeactivated(playerEntity));
    }

    @Override
    public void onUpdate(PlayerEntity playerEntity) {
        this.EMITTERS.forEach(quirk -> quirk.onDeactivated(playerEntity));
        this.TRANSFORMATION.forEach(quirk -> quirk.onDeactivated(playerEntity));
        this.MUTATION.forEach(quirk -> quirk.onDeactivated(playerEntity));
    }

    @Override
    public void keyUsage(PlayerEntity playerEntity, BNHUKeyBinds.Keys key, LogicalSide side) {
        for(int i = 0; i != 8; i++) {
            Quirk quirk = EMITTERS.get(i);
            if(quirk != null) {
                if(i == 0 && key.equals(BNHUKeyBinds.Keys.FIRST)) {
                    quirk.keyUsage(playerEntity, BNHUKeyBinds.Keys.FIRST, side);
                } else if(i == 1 && key.equals(BNHUKeyBinds.Keys.SECOND)) {
                    quirk.keyUsage(playerEntity, BNHUKeyBinds.Keys.SECOND, side);
                } else if(i == 2 && key.equals(BNHUKeyBinds.Keys.THIRD)) {
                    quirk.keyUsage(playerEntity, BNHUKeyBinds.Keys.THIRD, side);
                } else if(i == 3 && key.equals(BNHUKeyBinds.Keys.FOURTH)) {
                    quirk.keyUsage(playerEntity, BNHUKeyBinds.Keys.FOURTH, side);
                } else if(i == 4 && key.equals(BNHUKeyBinds.Keys.FIRST) && playerEntity.isSneaking()) {
                    quirk.keyUsage(playerEntity, BNHUKeyBinds.Keys.FIRST, side);
                } else if(i == 5 && key.equals(BNHUKeyBinds.Keys.SECOND) && playerEntity.isSneaking()) {
                    quirk.keyUsage(playerEntity, BNHUKeyBinds.Keys.SECOND, side);
                } else if(i == 6 && key.equals(BNHUKeyBinds.Keys.THIRD) && playerEntity.isSneaking()) {
                    quirk.keyUsage(playerEntity, BNHUKeyBinds.Keys.THIRD, side);
                } else if(i == 7 && key.equals(BNHUKeyBinds.Keys.FOURTH) && playerEntity.isSneaking()) {
                    quirk.keyUsage(playerEntity, BNHUKeyBinds.Keys.FOURTH, side);
                }
            }
        }
        if(key.equals(BNHUKeyBinds.Keys.FIFTH) && playerEntity.isSneaking()) {
            //Open GUI
        }
    }

    @Override
    public void renderLayer(AbstractClientPlayerEntity player, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(this.TRANSFORMATION.get(0) != null) this.TRANSFORMATION.get(0).renderLayer(player, matrixStack, buffer, packedLight, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
    }

    @Override
    public void renderModel(RenderPlayerEvent.Pre event) {
        if(this.MUTATION.get(0) != null) this.MUTATION.get(0).renderModel(event);
    }
}
