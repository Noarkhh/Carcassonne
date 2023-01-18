package game.segmented;

import game.core.Direction;
import game.core.Tile;
import game.graph.DFSTraverser;
import game.graph.Node;
import game.graph.NodeType;
import game.players.Player;
import game.players.PlayerManager;

import java.util.*;

public abstract class Segmented {
    protected final List<Tile> segments = new ArrayList<>();
    private Node rootNode;

    protected boolean completed = false;
    protected int pointsIfCompleted = 0;
    protected int pointsIfUncompleted = 0;
    protected final Map<Player, Integer> meeples = new HashMap<>();

    protected Segmented(Tile firstTile, Player claimer, NodeType segmentsType, PlayerManager playerManager) {
        segments.add(firstTile);
        for (Map.Entry<Direction, Node> entry : firstTile.getNodes().entrySet()) {
            if (entry.getValue().type == segmentsType) {
                rootNode = entry.getValue();
                break;
            }
        }

        for (Player player : playerManager.getPlayers()) {
            meeples.put(player, 0);
        }
        meeples.put(claimer, 1);
    }

    public List<Tile> getSegments() {
        return Collections.unmodifiableList(segments);
    }

    public Map<Player, Integer> getMeeples() {
        return Collections.unmodifiableMap(meeples);
    }

    public void addSegment(Tile tile) {
        segments.add(tile);
    }

    public void mergeWith(Segmented other) {
        segments.addAll(other.getSegments());
        for (Map.Entry<Player, Integer> entry : other.getMeeples().entrySet()) {
            Player player = entry.getKey();
            meeples.put(player, (meeples.get(player) + entry.getValue()));
        }
    }

    public void checkForCompleteness() {
        if (new DFSTraverser().isGraphComplete(rootNode)) {
            completed = true;
            tallyPoints();
        }
    }

    protected abstract void tallyPoints();
}
