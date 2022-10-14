package org.frb.kc.iloveotters.sports;

import org.frb.kc.iloveotters.core.Person;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;
        Player player = (Player) o;
        return isInjured == player.isInjured && position == player.position && Objects.equals(number, player.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isInjured, position, number);
    }
}
