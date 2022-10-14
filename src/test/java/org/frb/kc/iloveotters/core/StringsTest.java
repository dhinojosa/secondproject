package org.frb.kc.iloveotters.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringsTest {

    @Test
    public void testStringFormat() {
        //Format strings that you want by bringing in objects
        String result = String.format("The %s tickets are on sale at %d %s. I" +
                " love the %1$s",
            "Jonas Brothers", 40, "Dollars");
        System.out.println(result);
    }

    @Test
    public void testStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> groceries = Arrays.asList(
            "Avocados",
            "Lettuce",
            "Fresh Tomatoes",
            "Jalapeños",
            "Naan",
            "Eggs");

        for (int i = 0; i < groceries.size(); i++) {
            stringBuilder
                .append(String.format("%d. %s%n", i+1, groceries.get(i)));
        }

        String result = stringBuilder.toString();
        System.out.println(result);
    }
}
