package org.frb.kc.iloveotters.core;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MapTest {
    @Test
    public void testUsingAMap() {
        Map<String, Integer> romanNumerals = new HashMap<String, Integer>();
        romanNumerals.put("I", 1);
        romanNumerals.put("II", 2);
        romanNumerals.put("III", 3);
        romanNumerals.put("IV", 4);
        romanNumerals.put("V", 5);
        romanNumerals.put("VI", 6);
        romanNumerals.put("VII", 7);
        romanNumerals.put("VIII", 8);
        romanNumerals.put("IX", 9);
        romanNumerals.put("X", 10);
        romanNumerals.put("L", 50);
        romanNumerals.put("C", 100);
        romanNumerals.put("M", 1000);

        Integer i = romanNumerals.get("IX");
        System.out.println(i);
    }

    @Test
    public void testMapWithSomethingRealWorld() {
        Map<String, Callable<String>> webServer = new LinkedHashMap<>();
        webServer.put("/expenses", () -> "<html>....</html>");
        webServer.put("/currency/rates", () -> "<html>....</html>");
    }
}
