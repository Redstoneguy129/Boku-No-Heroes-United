package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities;

import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IPlayerCapability extends INBTSerializable<CompoundNBT> {
    void setLoggedInBefore(boolean loggedIn);
    boolean hasLoggedInBefore();

    void setQuirk(Quirk quirk);
    Quirk getQuirk();

    void copy(IPlayerCapability playerCapability);
}
