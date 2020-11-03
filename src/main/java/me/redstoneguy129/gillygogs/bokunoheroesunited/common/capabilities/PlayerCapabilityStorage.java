package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities;

import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.QuirkRegistry;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class PlayerCapabilityStorage implements Capability.IStorage<IPlayerCapability> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<IPlayerCapability> capability, IPlayerCapability instance, Direction side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putBoolean("loggedIn", instance.hasLoggedInBefore());
        tag.putInt("quirk", QuirkRegistry.getQuirkID(instance.getQuirk()));
        return tag;
    }

    @Override
    public void readNBT(Capability<IPlayerCapability> capability, IPlayerCapability instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setLoggedInBefore(tag.getBoolean("loggedIn"));
        instance.setQuirk(QuirkRegistry.quirkMap.get(tag.getInt("quirk")));
    }
}