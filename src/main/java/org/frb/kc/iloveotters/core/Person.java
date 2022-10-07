package org.frb.kc.iloveotters.core;

public class Person extends Object {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("Person[%s, %s]", firstName, lastName);
    }
}
