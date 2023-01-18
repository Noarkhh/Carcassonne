package game.players;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PlayerManager {
    private final List<Player> players = new LinkedList<>();

    public PlayerManager(List<PlayerColor> colors) {
        for (PlayerColor color : colors) {
            players.add(new Player(color));
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
