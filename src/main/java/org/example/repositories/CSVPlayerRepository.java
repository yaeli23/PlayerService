package org.example.repositories;

import org.example.models.Player;
import org.springframework.stereotype.Repository;
import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Repository class responsible for loads and maintains player data,
 * providing methods to access the stored data.
 */
@Repository
public class CSVPlayerRepository implements PlayerRepository {
    final String PLAYERS_DATA_FILE = "player.csv";
    private final Map<String, Player> players = new HashMap<>();

    public CSVPlayerRepository() {
        loadPlayers();
    }

    /**
     * Builds a Player from the given player data and headers.
     *
     * @param headers    an array of headers corresponding to the player data
     * @param playerData an array of player data
     * @return a Player containing the data from the CSV
     */
    private Player buildPlayer(String[] headers, String[] playerData) {
        Player player = new Player();
        try {
            for (int i = 0; i < headers.length; i++) {
                // add the "_" to match the fields of the Player class
                final String headerName = "_" + headers[i];

                // Use reflection to find the relevant field and set it
                Field field = Arrays.stream(Player.class.getDeclaredFields())
                        .filter(f -> f.getName().equalsIgnoreCase(headerName))
                        .findFirst()
                        .orElse(null);
                if (field != null) {
                    field.setAccessible(true);
                    field.set(player, playerData[i]);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return player;
    }

    /**
     * Loads player data from a CSV file and create the players map.
     */
    private void loadPlayers() {
        String[] playerData;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PLAYERS_DATA_FILE);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            CSVReader csvReader = new CSVReader(br);
            String[] headers = csvReader.readNext();
            while ((playerData = csvReader.readNext()) != null) {
                Player player = buildPlayer(headers, playerData);
                players.put(player.get_playerID(), player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all players
     *
     * @return a list of all players
     */
    @Override
    public List<Player> getPlayers() {
        return new ArrayList<>(players.values());
    }

    /**
     * Retrieves a player by their ID.
     *
     * @param playerId the ID of the player to retrieve
     * @return the player with the given ID if it exists, otherwise returns null
     */
    @Override
    public Player getPlayer(String playerId) {
        return players.getOrDefault(playerId, null);
    }
}
