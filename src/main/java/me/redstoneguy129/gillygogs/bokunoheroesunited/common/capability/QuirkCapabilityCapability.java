package me.redstoneguy129.gillygogs.bokunoheroesunited.common.capability;

public class QuirkCapabilityCapability implements IQuirkCapability {

    private int quirkID = -1;
    private boolean activated = false;

    @Override
    public void setQuirk(int quirkID) {
        this.quirkID = quirkID;
    }

    @Override
    public int getQuirk() {
        return this.quirkID;
    }

    @Override
    public void setQuirkActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public boolean isQuirkActivated() {
        return this.activated;
    }

    @Override
    public void Copy(IQuirkCapability quirk) {
        this.activated = quirk.isQuirkActivated();
        this.quirkID = quirk.getQuirk();
    }
}
