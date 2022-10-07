package org.frb.kc.iloveotters.sports;

import org.frb.kc.iloveotters.core.Person;

//Assumed to be Active NBA Player
public class Player extends Person {
    private boolean isInjured;
    private Position position;
    private JerseyNumber number;

    public Player(String firstName, String lastName, boolean isInjured,
                  Position position, JerseyNumber number) {
        super(firstName, lastName);
        this.isInjured = isInjured;
        this.position = position;
        this.number = number;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public Position getPosition() {
        return position;
    }

    public JerseyNumber getNumber() {
        return number;
    }
}
