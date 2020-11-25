package me.redstoneguy129.gillygogs.bokunoheroesunited.common.quirk;

public enum QuirkType {
    EMITTER,
    TRANSFORMATION,
    MUTANT;

    public boolean hasAppearance(Quirk quirk) {
        if(quirk.quirkType != EMITTER) {
            if(quirk.quirkType == MUTANT) return true;
            return quirk.activated;
        } else {
            return false;
        }
    }
}
