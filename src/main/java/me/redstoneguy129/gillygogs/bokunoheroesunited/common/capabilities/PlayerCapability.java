package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities;

import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.ResourceLocation;

public class PlayerCapability implements IPlayerCapability {
    private boolean loggedIn = false;
    private Quirk quirk = null;

    @Override
    public void setLoggedInBefore(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public boolean hasLoggedInBefore() {
        return this.loggedIn;
    }

    @Override
    public void setQuirk(Quirk quirk) {
        this.quirk = quirk;
    }

    @Override
    public Quirk getQuirk() {
        return this.quirk;
    }

    @Override
    public void copy(IPlayerCapability playerCapability) {
        this.loggedIn = playerCapability.hasLoggedInBefore();
        this.quirk = playerCapability.getQuirk();
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putBoolean("loggedIn", this.loggedIn);
        nbt.put("quirk", StringNBT.valueOf(Quirk.QUIRK.getKey(this.quirk).toString()));
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.loggedIn = nbt.getBoolean("loggedIn");
        this.quirk = Quirk.QUIRK.getValue(new ResourceLocation(nbt.get("quirk").getString()));
    }

}
