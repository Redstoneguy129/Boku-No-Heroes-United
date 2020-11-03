package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;

public class PlayerCapabilityProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(IPlayerCapability.class)
    public static Capability<IPlayerCapability> CAPABILITY = null;
    private final LazyOptional<IPlayerCapability> instance = LazyOptional.of(CAPABILITY::getDefaultInstance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == CAPABILITY ? instance.cast() : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return CAPABILITY.getStorage().writeNBT(CAPABILITY, instance.orElseThrow(() -> new IllegalArgumentException("Quirk must not be empty")), null);

    }

    @Override
    public void deserializeNBT(INBT nbt) {
        CAPABILITY.getStorage().readNBT(CAPABILITY, instance.orElseThrow(() -> new IllegalArgumentException("Quirk must not be empty!")), null, nbt);

    }
}