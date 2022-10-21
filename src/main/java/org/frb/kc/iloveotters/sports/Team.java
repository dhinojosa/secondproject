package org.frb.kc.iloveotters.sports;

import org.frb.kc.iloveotters.core.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

//Basketball
public class Team {
    //member variables, also called attributes
    private String mascot;
    private String name;
    private Person coach;
    private Person owner;
    private List<Player> players;

    public Team(String name) {
        this(name, null, null, null, new ArrayList<>());
    }

    public Team(String name, List<Player> roster) {
        this(name, null, null, null, roster);
    }

    public Team(String name, Person coach, Person owner) {
        this(name, coach, owner, null, new ArrayList<>());
    }

    public Team(String name, Person coach, Person owner, List<Player> roster) {
        this(name, coach, owner, null, roster);
    }

    public Team(String name, Person coach, Person owner, String mascot, List<Player> roster) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("No null names allowed");
        } else if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        if (roster == null) {
            throw new NullPointerException("Roster cannot be null");
        }
        this.name = name;
        this.coach = coach;
        this.owner = owner;
        this.mascot = mascot;
        this.players = roster;
    }



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

    public int size() {
        return this.players.size();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Team.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("players=" + players)
            .toString();
    }

    public Person coach() {
        return this.coach;
    }

    public Person owner() {
        return this.owner;
    }
}
