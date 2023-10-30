import org.example.models.Player;
import org.example.repositories.CSVPlayerRepository;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class CSVPlayerRepositoryTest {
    final int PLAYERS_SIZE = 19370;
    private CSVPlayerRepository repository;

    @Before
    public void setUp() {
        repository = new CSVPlayerRepository();
    }

    @Test
    public void testGetPlayers() {
        List<Player> players = repository.getPlayers();
        assertNotNull(players);
        assertFalse(players.isEmpty());
        assertEquals(PLAYERS_SIZE, players.size());
    }

    @Test
    public void testGetPlayer() {
        Player player = repository.getPlayer("aardsda01");
        assertNotNull(player);
        assertEquals("David", player.get_nameFirst());
    }
}
