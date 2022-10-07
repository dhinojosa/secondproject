package org.frb.kc.iloveotters;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testThatAPersonsStringRepresentationLookRight() {
        Person person = new Person("Linda", "Calder");
        System.out.println(person);
    }

    @Test
    public void testThatICanDoStringFromTheOutside() {
        Person person = new Person("Linda", "Calder");
        String format = String.format("%s %s", person.getFirstName(),
            person.getLastName());
        System.out.println(format);
    }

    //BankAccount

}
