package org.frb.kc.iloveotters.sports;

import org.frb.kc.iloveotters.core.Person;
import org.frb.kc.iloveotters.sports.Team;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

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
        System.out.println(dreamTeam);
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
}
