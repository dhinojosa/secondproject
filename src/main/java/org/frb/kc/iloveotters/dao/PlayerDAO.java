package org.frb.kc.iloveotters.dao;

import org.frb.kc.iloveotters.sports.JerseyNumber;
import org.frb.kc.iloveotters.sports.Player;
import org.frb.kc.iloveotters.sports.Position;

import java.util.List;

public interface PlayerDAO {
    Long persist(Player player);
    Player findById(Long id);
    List<Player> findByPosition(Position position);
    List<Player> findByJerseyNumber(JerseyNumber jerseyNumber);
}
