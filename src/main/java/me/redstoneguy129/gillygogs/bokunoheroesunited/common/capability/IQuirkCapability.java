package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capability;

public interface IQuirkCapability {

    void setQuirk(int quirkID);
    int getQuirk();

    void setQuirkActivated(boolean activated);
    boolean isQuirkActivated();

    void Copy(IQuirkCapability quirk);
}
