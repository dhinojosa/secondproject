package org.frb.kc.iloveotters.sports;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testCreationOfStephenCurry() {
        Player stephenCurry =
            new Player("Stephen", "Curry", false,
                Position.POINT_GUARD, new JerseyNumber("30"));
        JerseyNumber number = stephenCurry.getNumber();
        String value = number.getValue();
        assertEquals("30", value);
    }


    @Test
    public void testStephenCurryReallyStephenCurry() {
        Player stephenCurry =
            new Player("Stephen", "Curry", false,
                Position.POINT_GUARD, new JerseyNumber("30"));
        Player stephenCurry2 =
            new Player("Stephen", "Curry", true,
                Position.POINT_GUARD, new JerseyNumber("30"));

        assertNotEquals(stephenCurry, stephenCurry2);
    }

    @Test
    public void testTwoDifferentPointGuardsWithNearlySameAttributes() {
        JerseyNumber number = new JerseyNumber("30");
        Player stephenCurry =
            new Player("Stephen", "Curry", false,
                Position.POINT_GUARD, number);
        Player stephenCurry2 =
            new Player("Luka", "Doncic", false,
                Position.POINT_GUARD, number);

        assertEquals(stephenCurry, stephenCurry2);
    }

    @Test
    public void testList() {
        List<Player> players = Arrays.asList(
            new Player("Stephen", "Curry", false,
                Position.POINT_GUARD, new JerseyNumber("30")),
            new Player("LeBron", "James", false,
                Position.POWER_FORWARD, new JerseyNumber("6")),
            new Player("Sue", "Bird", false, Position.POINT_GUARD,
                new JerseyNumber("10"))
        );
        System.out.println(players.size());
    }

    @Test
    public void testAnotherWayToCreateAList() {
        List<Player> players = new ArrayList<>();
        players.add(
            new Player("Clay", "Thompson", false, Position.SHOOTING_GUARD,
                new JerseyNumber("11")));
        players.add(new Player("Sue", "Bird", false, Position.POINT_GUARD,
            new JerseyNumber("10")));
        System.out.println(players.size());
    }
}
