package io.github.kabanfriends.forcegl30.override;

public class HintOverride {

    private final OverrideType overrideType;
    private final int value;

    public HintOverride(OverrideType overrideType, int value) {
        this.overrideType = overrideType;
        this.value = value;
    }

    public OverrideType getOverrideType() {
        return overrideType;
    }

    public int getValue() {
        return value;
    }
}
