package org.frb.kc.iloveotters.core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

    @Test
    public void testCompatibilityWithArrays() {
        int[] myArray = new int[20];
        myArray[0] = 30;
        myArray[1] = 50;

        Integer[] myArray2 = new Integer[]{10, 40, 60, 11, 22, 40, 50};

        List<Integer> integers = Arrays.asList(1, 2, 4, 50, 10000, 60000,
            13000, 40000);
        System.out.println(integers);

        List<Integer> ints = Arrays.asList(myArray2);
        System.out.println(ints);
    }

    @Test
    public void testCreateList() {
        List<Integer> integers = new ArrayList<>();
    }
}
