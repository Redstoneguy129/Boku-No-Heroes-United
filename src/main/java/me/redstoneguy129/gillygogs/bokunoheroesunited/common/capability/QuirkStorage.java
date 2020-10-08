package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class QuirkStorage implements Capability.IStorage<IQuirkCapability> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<IQuirkCapability> capability, IQuirkCapability instance, Direction side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putBoolean("activated", instance.isQuirkActivated());
        tag.putInt("quirkID", instance.getQuirk());
        return tag;
    }

    @Override
    public void readNBT(Capability<IQuirkCapability> capability, IQuirkCapability instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setQuirkActivated(tag.getBoolean("activated"));
        instance.setQuirk(tag.getInt("quirkID"));
    }
}
