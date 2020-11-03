package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capabilities;

import me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk.Quirk;

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
}
