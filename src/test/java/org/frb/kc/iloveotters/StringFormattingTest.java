package org.frb.kc.iloveotters;

import org.junit.Test;

public class StringFormattingTest {

    @Test
    public void testStringFormat() {
        //Format strings that you want by bringing in objects
        String result = String.format("The %s tickets are on sale at %d %s. I" +
                " love the %1$s",
            "Jonas Brothers", 40, "Dollars");
        System.out.println(result);
    }

}
