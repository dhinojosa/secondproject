package org.frb.kc.iloveotters.sports;

import org.frb.kc.iloveotters.core.Person;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Basketball
public class Team {
    //member variables, also called attributes
    private final String mascot;
    private final String name;
    private final Person coach;
    private final Person owner;
    private final List<Player> players;

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

    public Team(String name, Person coach, Person owner, String mascot,
                List<Player> roster) {
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

    public Optional<Person> coach() {
        return Optional.ofNullable(coach);
    }

    public Optional<Person> owner() {
        return Optional.ofNullable(owner);
    }

    public String mascot() {
        return mascot;
    }

    public List<Player> findPlayerByPosition(Position position) {
        return players
            .stream()
            .filter(player -> player.getPosition().equals(position))
            .sorted()
            .collect(Collectors.toList());
    }


    public List<Player> findPlayerByPositionClassic(Position position) {
        List<Player> result = new ArrayList<>();
        for (Player player : players) {
            if (player.getPosition().equals(position)) {
                result.add(player);
            }
        }
        Collections.sort(result); //old way, and mutable
        return result;
    }

    public List<Player> findPlayerByPosition(Position position,
                                             Comparator<Player> playerComparator) {
        return
            findPlayerByPosition(position)
                .stream()
                .sorted(playerComparator)
                .collect(Collectors.toList());
    }

    public List<Player> findPlayerByPositionClassic(Position position,
                                                    Comparator<Player> playerComparator) {
        List<Player> result = findPlayerByPosition(position);
        result.sort(playerComparator);
        return result;
    }
}
