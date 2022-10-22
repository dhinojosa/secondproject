package org.frb.kc.iloveotters.core;

import org.junit.Test;

import java.util.*;

public class SetTest {

    @Test
    public void testUsingSet() {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(30);
        set.add(60);
        set.add(110);
        set.add(33);
        set.add(11);
        set.add(22);
        set.add(33);
        set.add(937);
        System.out.println(set);
    }

    @Test
    public void testPersonSet() {
        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("Raj", "Sundaresan"));
        personSet.add(new Person("Raj", "Sundaresan"));
        personSet.add(new Person("Linda", "Calder"));
        personSet.add(new Person("Angela", "Eason"));
        personSet.add(new Person("Angela", "Eason"));
        personSet.add(new Person("Samuel", "Dongeso"));
        personSet.add(new Person("Shirley", "Seller"));
        System.out.println(personSet);
    }

    @Test
    public void testPersonTreeSetWithNaturalOrdering() {
        Set<Person> personSet = new TreeSet<>();
        personSet.add(new Person("Raj", "Sundaresan"));
        personSet.add(new Person("Linda", "Calder"));
        personSet.add(new Person("Angela", "Eason"));
        personSet.add(new Person("Samuel", "Dongeso"));
        personSet.add(new Person("Shirley", "Seller"));
        System.out.println(personSet);
    }

    @Test
    public void testPersonTreeSetWithUnnaturalOrdering() {
        Set<Person> personSet = new TreeSet<>(
            new PersonByLastNameComparator());
        personSet.add(new Person("Raj", "Sundaresan"));
        personSet.add(new Person("Linda", "Calder"));
        personSet.add(new Person("Angela", "Eason"));
        personSet.add(new Person("Samuel", "Dongeso"));
        personSet.add(new Person("Shirley", "Seller"));
        System.out.println(personSet);
    }

    @Test
    public void testPersonTreeSetWithUnnaturalOrderingAnonymously() {
        Set<Person> personSet = new TreeSet<>(Comparator.comparing(Person::getLastName));
        personSet.add(new Person("Raj", "Sundaresan"));
        personSet.add(new Person("Linda", "Calder"));
        personSet.add(new Person("Angela", "Eason"));
        personSet.add(new Person("Samuel", "Dongeso"));
        personSet.add(new Person("Shirley", "Seller"));
        System.out.println(personSet);
    }


    @Test
    public void testUsingList() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(30);
        arrayList.add(60);
        arrayList.add(110);
        arrayList.add(33);
        arrayList.add(11);
        arrayList.add(22);
        arrayList.add(937);
        System.out.println(arrayList);
    }
}
