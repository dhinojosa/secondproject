package org.frb.kc.iloveotters.sports;

import java.util.StringJoiner;

public enum Position {
    CENTER("Center"),
    POWER_FORWARD("Power Forward"),
    SMALL_FORWARD("Small Forward"),
    POINT_GUARD("Point Guard"),
    SHOOTING_GUARD("Shooting Guard");

    private final String description;

    Position(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
