package org.frb.kc.iloveotters.dao;

import org.frb.kc.iloveotters.sports.JerseyNumber;
import org.frb.kc.iloveotters.sports.Player;
import org.frb.kc.iloveotters.sports.Position;

import java.util.Arrays;
import java.util.List;

public class OraclePlayerDAO implements PlayerDAO{
    @Override
    public Long persist(Player player) {
        System.out.println("Oracle persist");
        return 19292L;
    }

    @Override
    public Player findById(Long id) {
        System.out.println("Oracle findById");
        return Player.of("Sammy", "Swanson", Position.POWER_FORWARD, "22");
    }

    @Override
    public List<Player> findByPosition(Position position) {
        System.out.println("Oracle findByPosition");
        return Arrays.asList(
            Player.of("Sammy", "Swanson", Position.POWER_FORWARD, "22"),
            Player.of("Ezekiel", "Dolphinfin", Position.POWER_FORWARD, "22")
        );
    }

    @Override
    public List<Player> findByJerseyNumber(JerseyNumber jerseyNumber) {
        System.out.println("Oracle findByPosition");
        return Arrays.asList(
            Player.of("Sammy", "Swanson", Position.POWER_FORWARD, "22"),
            Player.of("Ezekiel", "Dolphinfin", Position.POWER_FORWARD, "22")
        );
    }
}
