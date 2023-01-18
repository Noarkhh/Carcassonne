package game.segmented;

import game.core.Feature;
import game.core.Tile;
import game.graph.NodeType;
import game.players.Player;
import game.players.PlayerManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class City extends Segmented {
    protected City(Tile firstTile, Player claimer, NodeType segmentsType, PlayerManager playerManager) {
        super(firstTile, claimer, segmentsType, playerManager);
    }

    @Override
    protected void tallyPoints() {
        int pointsPerTile = completed ? 2 : 1;
        int totalPoints = 0;
        for (Tile segment : segments) {
            totalPoints += pointsPerTile;
            if (segment.feature == Feature.SHIELD) totalPoints += pointsPerTile;
        }
        Player disputeWinner = Collections.max(meeples.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        disputeWinner.addPoints(totalPoints);
    }
}
