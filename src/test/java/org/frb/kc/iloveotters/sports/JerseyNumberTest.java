package org.frb.kc.iloveotters.sports;

import org.junit.Test;

import static org.junit.Assert.*;

public class JerseyNumberTest {
    @Test
    public void testJerseyHasToBeAValidNumber() {
        try {
            new JerseyNumber("-1");
            fail("Should not run");
        } catch (IllegalArgumentException iae) {
            assertTrue(true);
        }
    }

    @Test
    public void testJerseyHasToBeAValidNumberLessThan100() {
        try {
            new JerseyNumber("1000");
            fail("Should not run");
        } catch (IllegalArgumentException iae) {
            assertTrue(true);
        }
    }

    @Test
    public void testJerseyOf00IsOk() {
        JerseyNumber jerseyNumber = new JerseyNumber("00");
        assertNotNull(jerseyNumber);
    }
}
