package org.frb.kc.iloveotters;

import java.util.Objects;

public class Team {
    //coach == oooh
    //owner == oooh
    //sport == oooh
    //shouldn't wins and losses be in a season
    //collection seasons
    //roster = collection of players
    //defense == collection of players
    //offense == collection of players

    //perhaps a for loop or while to filter
    // players by offense or defense.


    //member variables, also called attributes
    //TODO: lock the member variables
    int losses;
    String name;
    int size;
    int wins;

    public Team(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("No null names allowed");
        } else if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }

        this.name = name;
    }

    //we will add a player
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

//assign loss name wins
    //main method
    //can we do a test?

   class BankAccount {
       private float balance;

       public void deposit(float amt);
       public float withdrawl(float amt);
   }


   class SomethingElse {
       BankAccount bankAccount;

       method1() {
           bankAccount.balance += 100100;
       }

   }
}
