package org.example.controllers;

import org.example.models.Player;
import org.example.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * The Controller class responsible for serves the contents of players
 */
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/players")
@RestController
public class PlayerController {
    private final PlayerRepository playerRepository;

    /**
     * This constructor is responsible for injecting the appropriate PlayerRepository implementation.
     * If there are multiple implementations of PlayerRepository,
     * it is necessary to use a qualifier to specify which implementation to inject.
     *
     * @param playerRepository the PlayerRepository implementation to be injected
     */
    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Get all players
     *
     * @return a list of players
     */
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.getPlayers();
    }

    /**
     * Get a specific player by ID.
     *
     * @param playerID the ID of the player
     * @return the player corresponding to the given ID
     */
    @GetMapping("/{playerID}")
    public Player getPlayerByID(@PathVariable String playerID) {
        return playerRepository.getPlayer(playerID);
    }
}
