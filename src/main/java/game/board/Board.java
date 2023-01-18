package game.board;

import game.core.Direction;
import game.core.Tile;
import game.core.Vector;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<Vector, Tile> tiles = new HashMap<>();

    public Board() {

    }

    public boolean place(Tile tile) {
        Vector tilePosition = tile.getPosition();

        if (tiles.containsKey(tilePosition)) return false;
        for (Direction direction : Direction.values()) {
            Vector neighbourPosition = tilePosition.add(direction.toUnitVector());
            if (tiles.containsKey(neighbourPosition) && !tile.canConnectTo(tiles.get(neighbourPosition))) return false;
        }
        tiles.put(tilePosition, tile);

        for (Direction direction : Direction.values()) {
            Vector neighbourPosition = tilePosition.add(direction.toUnitVector());
            if (tiles.containsKey(neighbourPosition)) {
                tile.connectTo(tiles.get(neighbourPosition));
            }
        }
        return true;
    }
}
