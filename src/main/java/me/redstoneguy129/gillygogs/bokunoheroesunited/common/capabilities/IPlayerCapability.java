package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities;

import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;

public interface IPlayerCapability {
    void setLoggedInBefore(boolean loggedIn);
    boolean hasLoggedInBefore();

    void setQuirk(Quirk quirk);
    Quirk getQuirk();

    void copy(IPlayerCapability playerCapability);
}
