package org.example.repositories;

import org.example.models.Player;
import java.util.List;

public interface PlayerRepository {
    List<Player> getPlayers();
    Player getPlayer(String playerId);
}