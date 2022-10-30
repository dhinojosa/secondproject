package org.frb.kc.iloveotters.core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListTest {

    @Test
    private void testCreatingAnArrayClassic() {
        int[] myArray = new int[20];
        myArray[0] = 30;
        myArray[1] = 50;
    }

    @Test
    private void testCreatingAListWithVarArgs() {
        List<Integer> integers = Arrays.asList(1, 2, 4, 50, 10000, 60000,
            13000, 40000);
        System.out.println(integers);
    }

    @Test
    public void testCreateList() {
        List<Integer> integers = new ArrayList<>();
        Stream<Integer> stream = integers.stream();
    }

    @Test
    public void testCompatibilityWithArrays() {
        int[] myArray2 = new int[]{10, 40, 60, 11, 22, 40, 50};
        //IntStream - intStream is highly specialized stream
        IntStream stream = Arrays.stream(myArray2);

        List<Integer> integerList =
            stream.boxed().collect(Collectors.toList());
    }
}
