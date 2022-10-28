package org.frb.kc.iloveotters.sports;

import org.frb.kc.iloveotters.core.Person;
import org.frb.kc.iloveotters.sports.Team;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class TeamTest {

    @Test
    public void testConstructionWithNameKansasCityRoyals() {
        Team team = new Team("Kansas City Royals");
        assertEquals("Kansas City Royals", team.getName());
    }

    @Test
    public void testConstructionWithNameCincinnatiReds() {
        Team team = new Team("Cincinnati Reds");
        assertEquals("Cincinnati Reds", team.getName());
    }

    @Test
    public void testConstructionShouldNotAcceptAnEmptyString() {
        try {
            Team team = new Team("");
            fail("This shouldn't have succeeded");
        } catch (IllegalArgumentException iae) {
            assertTrue(true);
        }
    }

    @Test
    public void testConstructionShouldNotAcceptANull() {
        try {
            Team team = new Team(null);
            fail("This shouldn't have succeeded");
        } catch (NullPointerException npe) {
            assertEquals("Name cannot be null", npe.getMessage());
        }
    }

    @Test
    public void testTeamEquality() {
        Team team1 = new Team("Brooklyn Nets");
        Team team2 = new Team("Brooklyn Nets");
        assertNotSame(team1, team2);      //false
        assertEquals(team1, team2);  //false
        assertEquals(team1.getName(), team2.getName());
    }

    @Test
    public void testAddPlayerToTheRoster() {
        Team dreamTeam = new Team("Seattle Supersonics",
            Collections.singletonList(new Player("Hema", "Penugonda", false,
                Position.POWER_FORWARD, new JerseyNumber("44"))));
        int size = dreamTeam.size();
        assertEquals(1, size);
    }

    @Test
    public void testDifferentWaysToMakeLists() {
        List<Integer> listOne = new ArrayList<>();
        listOne.add(3);
        listOne.add(4);

        List<Integer> listTwo = Arrays.asList(1, 2, 3, 5);

        List<Integer> listThree = Collections.singletonList(10);
    }

    @Test
    public void testAddPlayerToTheRosterUsingSecondaryConstructor() {
        Team dreamTeam = new Team("Seattle Supersonics",
            new Person("Bindu", "Kandanat"), new Person("Emily", "Lynn"), Arrays.asList(new Player("Hema", "Penugonda", false,
            Position.POWER_FORWARD, new JerseyNumber("44"))));
        int size = dreamTeam.size();
        assertEquals(1, size);
    }

    @Test
    public void testToString() {
        Team dreamTeam = new Team("Seattle Supersonics",
            Arrays.asList(new Player("Hema", "Penugonda", false,
                Position.POWER_FORWARD, new JerseyNumber("44")), new Player("Ritesh", "Saraff", false,
                Position.SMALL_FORWARD, new JerseyNumber("43"))));
        assertThat(dreamTeam.toString()).isEqualTo("Team[name='Seattle Supersonics', players=[Person[Hema, Penugonda], Person[Ritesh, Saraff]]]");
    }

    @Test
    public void testAddCoach() {
        Team dreamTeam = new Team("Seattle Supersonics",
            new Person("Bindu", "Kandanat"), new Person("Emily", "Lynn"));

        //You can do this old style accessor
        //Person coach = dreamTeam.getCoach();

        // or this new style accessor
        Optional<Person> coach = dreamTeam.coach();
        assertEquals("Bindu", coach.orElse(new Person("Mirza", "Alam")).getFirstName());

        Optional<Person> owner = dreamTeam.owner();
        assertEquals("Emily", owner.orElse(new Person("Melissa", "Wachter")).getFirstName());
        // but this..
        // Old style setter to set something
        // And we are overtime likely going avoid this altogether
        // Team dreamTeam = new Team("Seattle Supersonics");
        // dreamTeam.setCoach(new Person("Bindu", "Kandanat"));
    }

    @Test
    public void testRosterFromTeamWithNameCoachAndOwner() {
        Team dreamTeam = new Team("Seattle Supersonics",
            new Person("Bindu", "Kandanat"), new Person("Emily", "Lynn"));
        assertEquals(0, dreamTeam.size());
    }

    @Test
    public void testGettingTheCoachFromTeamWithNameCoachAndOwner() {
        Person coach = new Person("Bindu", "Kandanat");
        Team dreamTeam = new Team("Seattle Supersonics",
            coach, new Person("Emily", "Lynn"));
        assertEquals(coach, dreamTeam.coach().orElse(new Person("Mirza", "Alam")));
    }

    @Test
    public void testGettingTheCoachFromTeamWithNameNoCoachAndNoOwner() {
        Team dreamTeam = new Team("Seattle Supersonics");
        Person person = dreamTeam.coach().orElse(new Person("Mirza", "Alam"));
        assertEquals("Mirza", person.getFirstName());
    }

    @Test
    public void testFilterPlayerByPosition() {
        Team dreamTeam = new Team("Seattle Supersonics", Arrays.asList(
            new Player("Emily", "Lynn", false, Position.POINT_GUARD, new JerseyNumber("30")),
            new Player("Samuel", "Dongeso", false, Position.SHOOTING_GUARD, new JerseyNumber("12")),
            new Player("Shirley", "Seller", false, Position.SMALL_FORWARD, new JerseyNumber("19")),
            new Player("Raj", "Sundaresan", false, Position.CENTER, new JerseyNumber("44")),
            new Player("Melissa", "Wachter", false, Position.POWER_FORWARD, new JerseyNumber("33"))
        ));
        List<Player> smallForwardList =
            dreamTeam.findPlayerByPosition(Position.SMALL_FORWARD);
        assertThat(smallForwardList).hasSize(1);
    }

    @Test
    public void testFilterPlayerByPositionWithTwoSmallForwards() {
        Team dreamTeam = new Team("Seattle Supersonics", Arrays.asList(
            new Player("Emily", "Lynn", false, Position.POINT_GUARD, new JerseyNumber("30")),
            new Player("Samuel", "Dongeso", false, Position.SHOOTING_GUARD, new JerseyNumber("12")),
            new Player("Shirley", "Seller", false, Position.SMALL_FORWARD, new JerseyNumber("19")),
            new Player("Raj", "Sundaresan", false, Position.CENTER, new JerseyNumber("44")),
            new Player("Aaron", "Hall", false, Position.SMALL_FORWARD, new JerseyNumber("22")),
            new Player("Melissa", "Wachter", false, Position.POWER_FORWARD, new JerseyNumber("33"))
        ));
        List<Player> smallForwardList =
            dreamTeam.findPlayerByPosition(Position.SMALL_FORWARD);
        assertThat(smallForwardList).hasSize(2);
    }


    @Test
    public void testFilterPlayerByPositionWithThreeSmallForwardsWithNaturalOrdering() {
        Player shirley = new Player("Shirley", "Seller", false,
            Position.SMALL_FORWARD, new JerseyNumber("19"));
        Player aaron = new Player("Aaron", "Hall", false,
            Position.SMALL_FORWARD, new JerseyNumber("22"));
        Player jay = new Player("Jay", "Raja", false,
            Position.SMALL_FORWARD, new JerseyNumber("11"));
        Team dreamTeam = new Team("Seattle Supersonics", Arrays.asList(
            new Player("Emily", "Lynn", false, Position.POINT_GUARD, new JerseyNumber("30")),
            new Player("Samuel", "Dongeso", false, Position.SHOOTING_GUARD, new JerseyNumber("12")),
            shirley,
            new Player("Raj", "Sundaresan", false, Position.CENTER, new JerseyNumber("44")),
            aaron,
            new Player("Melissa", "Wachter", false, Position.POWER_FORWARD, new JerseyNumber("33")),
            jay
        ));
        List<Player> smallForwardList =
            dreamTeam.findPlayerByPosition(Position.SMALL_FORWARD);
        assertThat(smallForwardList).isEqualTo(Arrays.asList(aaron, jay, shirley));
    }

    @Test
    public void testFilterPlayerByPositionWithThreeSmallForwardsWithCustomOrderingByJerseyNumber() {
        Player shirley = new Player("Shirley", "Seller", false,
            Position.SMALL_FORWARD, new JerseyNumber("19"));
        Player aaron = new Player("Aaron", "Hall", false,
            Position.SMALL_FORWARD, new JerseyNumber("22"));
        Player jay = new Player("Jay", "Raja", false,
            Position.SMALL_FORWARD, new JerseyNumber("11"));

        Team dreamTeam = new Team("Seattle Supersonics", Arrays.asList(
            new Player("Emily", "Lynn", false, Position.POINT_GUARD, new JerseyNumber("30")),
            new Player("Samuel", "Dongeso", false, Position.SHOOTING_GUARD, new JerseyNumber("12")),
            shirley,
            new Player("Raj", "Sundaresan", false, Position.CENTER, new JerseyNumber("44")),
            aaron,
            new Player("Melissa", "Wachter", false, Position.POWER_FORWARD, new JerseyNumber("33")),
            jay
        ));
        List<Player> smallForwardList =
            dreamTeam.findPlayerByPosition(Position.SMALL_FORWARD, Comparator.comparing(player -> player.getNumber().getValue()));
        assertThat(smallForwardList).isEqualTo(Arrays.asList(jay, shirley, aaron));
    }

    @Test
    public void testFilterPlayerByPositionWithOneSmallPointGuard() {
        Team dreamTeam = new Team("Seattle Supersonics", Arrays.asList(
            new Player("Emily", "Lynn", false, Position.POINT_GUARD, new JerseyNumber("30")),
            new Player("Samuel", "Dongeso", false, Position.SHOOTING_GUARD, new JerseyNumber("12")),
            new Player("Shirley", "Seller", false, Position.SMALL_FORWARD, new JerseyNumber("19")),
            new Player("Raj", "Sundaresan", false, Position.CENTER, new JerseyNumber("44")),
            new Player("Aaron", "Hall", false, Position.SMALL_FORWARD, new JerseyNumber("22")),
            new Player("Melissa", "Wachter", false, Position.POWER_FORWARD, new JerseyNumber("33"))
        ));
        List<Player> smallForwardList =
            dreamTeam.findPlayerByPosition(Position.POINT_GUARD);
        assertThat(smallForwardList).hasSize(1);
    }

    @Test
    public void testFilterPlayerByPositionWithSmallPointGuardButNoneAvailable() {
        Team dreamTeam = new Team("Seattle Supersonics", Arrays.asList(
            new Player("Samuel", "Dongeso", false, Position.SHOOTING_GUARD, new JerseyNumber("12")),
            new Player("Shirley", "Seller", false, Position.SMALL_FORWARD, new JerseyNumber("19")),
            new Player("Raj", "Sundaresan", false, Position.CENTER, new JerseyNumber("44")),
            new Player("Aaron", "Hall", false, Position.SMALL_FORWARD, new JerseyNumber("22")),
            new Player("Melissa", "Wachter", false, Position.POWER_FORWARD, new JerseyNumber("33"))
        ));
        List<Player> smallForwardList =
            dreamTeam.findPlayerByPosition(Position.POINT_GUARD);
        assertThat(smallForwardList).hasSize(0);
    }
}
