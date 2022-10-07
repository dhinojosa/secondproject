package org.frb.kc.iloveotters;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testThatAPersonsStringRepresentationLookRight() {
        Person person = new Person("Linda", "Calder");
        System.out.println(person);
    }
}
