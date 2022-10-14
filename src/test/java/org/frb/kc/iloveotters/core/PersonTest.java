package org.frb.kc.iloveotters.core;

import org.frb.kc.iloveotters.core.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    @Test
    public void testThatLindaIsLinda() {
        Person person1 = new Person("Linda", "Calder");
        Person person2 = new Person("Linda", "Calder");
        assertEquals(person1, person2);
    }


    @Test
    public void testThatLindaIsNotJay() {
        Person person1 = new Person("Linda", "Calder");
        Person person2 = new Person("Jay", "Raja");
        assertNotEquals(person1, person2);
    }
}
