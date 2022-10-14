package org.frb.kc.iloveotters.sports;

import org.frb.kc.iloveotters.dao.PlayerDAO;

import java.util.List;

public class PlayerRegistration {
    private PlayerDAO playerDAO;

    public PlayerRegistration(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void registerNewPlayer(Player player) {
        List<Player> jerseyNumberList =
            playerDAO.findByJerseyNumber(player.getNumber());
        if (jerseyNumberList.size() >= 10) {
            throw new IllegalArgumentException("Too many players with that number");
        } else {
            playerDAO.persist(player);
        }
    }
}
