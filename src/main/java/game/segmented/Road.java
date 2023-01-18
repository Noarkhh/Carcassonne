package game.segmented;

import game.core.Feature;
import game.core.Tile;
import game.graph.NodeType;
import game.players.Player;
import game.players.PlayerManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Road extends Segmented {
    protected Road(Tile firstTile, Player claimer, NodeType segmentsType, PlayerManager playerManager) {
        super(firstTile, claimer, segmentsType, playerManager);
    }

    @Override
    protected void tallyPoints() {
        Player disputeWinner = Collections.max(meeples.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        disputeWinner.addPoints(segments.size());
    }
}
