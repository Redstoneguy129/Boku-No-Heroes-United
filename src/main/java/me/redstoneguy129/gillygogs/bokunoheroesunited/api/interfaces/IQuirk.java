package me.redstoneguy129.gillygogs.bokunoheroesunited.api.interfaces;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderPlayerEvent;

public interface IQuirk {
    default void render(PlayerEntity player, PlayerRenderer renderer, float tick, MatrixStack stack, IRenderTypeBuffer buffers, int light) {};

    default void FirstKey(PlayerEntity playerEntity) {}
    default void SecondKey(PlayerEntity playerEntity) {}
    default void ThirdKey(PlayerEntity playerEntity) {}
    default void FourthKey(PlayerEntity playerEntity) {}
    default void FifthKey(PlayerEntity playerEntity) {}

    void Ambience(PlayerEntity playerEntity);

}
