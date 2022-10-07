package org.frb.kc.iloveotters.sports;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testCreationOfPlayer() {
        Player player =
            new Player("Stephen", "Curry", false,
                Position.POINT_GUARD, new JerseyNumber("30"));
        String value = player.getNumber().getValue();
        assertEquals("30", value);
    }
}
