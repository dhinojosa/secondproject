package org.frb.kc.iloveotters.sports;

import java.util.Objects;

//Basketball
public class Team {
    //coach == oooh
    //owner == oooh

    //shouldn't wins and losses be in a season (Is this the right place)
    //perhaps consider a season?

    //roster = collection of players

    //member variables, also called attributes
    //TODO: lock the member variables

    private String name;
    //int size; ?

    public Team(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("No null names allowed");
        } else if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }

        this.name = name;
    }

    // we will add a player
    // player will have a position
    // based on the position are they offense or defense?

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Team team = (Team) other;
        return name.equals(team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    //TODO: toString
}
