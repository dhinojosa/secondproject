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

    @Test
    public void testJerseyNumberOf30IsEqualToAnotherJerseyOf30() {
        JerseyNumber jerseyNumber1 = new JerseyNumber("30");
        JerseyNumber jerseyNumber2 = new JerseyNumber("30");
        jerseyNumber1.equals(jerseyNumber2);
        assertEquals(jerseyNumber1, jerseyNumber2);
    }

    @Test
    public void testThatJerseyDoesntAcceptANull() {
        try {
            new JerseyNumber(null);
            fail("This line should never be invoked");
        } catch (NullPointerException e) {
            assertEquals("Jersey number cannot be null", e.getMessage());
        }
    }
}
