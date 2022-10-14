package org.frb.kc.iloveotters.sports;

import org.frb.kc.iloveotters.dao.MySQLPlayerDAO;
import org.frb.kc.iloveotters.dao.OraclePlayerDAO;
import org.frb.kc.iloveotters.dao.OracleUpgradePlayerDAO;
import org.frb.kc.iloveotters.dao.PlayerDAO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerRegistrationTest {

    @Test
    public void testThatPlayerHasANumberThatIsPastTheCap() {
        //Anonymous Instantion
        PlayerDAO playerDAO = new PlayerDAO() {
            @Override
            public Long persist(Player player) {
                fail("This should not be called");
                return 144L;
            }

            @Override
            public Player findById(Long id) {
                return null;
            }

            @Override
            public List<Player> findByPosition(Position position) {
                return null;
            }

            @Override
            public List<Player> findByJerseyNumber(JerseyNumber jerseyNumber) {
                ArrayList<Player> players = new ArrayList<>();
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                players.add(Player.of("A", "B", Position.POINT_GUARD, "10"));
                return players;
            }
        };
        PlayerRegistration playerRegistration = new PlayerRegistration(playerDAO);

        try {
            playerRegistration.registerNewPlayer(Player.of("Bob", "Homie",
                Position.CENTER, "10"));
            fail("Should not work");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    //Integration
    @Test
    public void testPlayerRegisterWithMySQLDatabase() {
        PlayerRegistration playerRegistration = new PlayerRegistration(new MySQLPlayerDAO());
        playerRegistration.registerNewPlayer(Player.of("Carla", "Fancyfeet",
            Position.SMALL_FORWARD, "12"));
    }

    @Test
    public void testPlayerRegisterWithOracleDatabase() {
        PlayerRegistration playerRegistration = new PlayerRegistration(new OraclePlayerDAO());
        playerRegistration.registerNewPlayer(Player.of("Carla", "Fancyfeet",
            Position.SMALL_FORWARD, "12"));
    }

    @Test
    public void testPlayerRegisterWithOracleUpgradeDatabase() {
        PlayerRegistration playerRegistration = new PlayerRegistration(new OracleUpgradePlayerDAO());
        playerRegistration.registerNewPlayer(Player.of("Carla", "Fancyfeet",
            Position.SMALL_FORWARD, "12"));
    }
}
