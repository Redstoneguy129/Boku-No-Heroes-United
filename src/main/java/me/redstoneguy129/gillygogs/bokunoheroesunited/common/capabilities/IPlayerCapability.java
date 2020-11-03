package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities;

import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.IQuirk;

public interface IPlayerCapability {
    void setLoggedInBefore(boolean loggedIn);
    boolean hasLoggedInBefore();

    void setQuirk(IQuirk quirk);
    IQuirk getQuirk();

    void copy(IPlayerCapability playerCapability);
}
