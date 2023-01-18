package game.core;

import game.graph.Edge;
import game.graph.Node;
import game.graph.NodeType;

import java.util.*;

public class Tile {
    private final Map<Direction, Node> nodes = new EnumMap<>(Direction.class);
    public final Feature feature;
    private Vector position = new Vector(0, 0);

    public Tile(Map<Direction, NodeType> nodesTypes, List<Edge> internalEdges, Feature feature) {
        this.feature = feature;
        for (Map.Entry<Direction, NodeType> entry : nodesTypes.entrySet()) {
            nodes.put(entry.getKey(), new Node(entry.getValue()));
        }

        for (Edge edge : internalEdges) {
            edge.getNodes().get(0).addNeighbours(edge.getNodes().get(1));
            edge.getNodes().get(1).addNeighbours(edge.getNodes().get(0));
        }

        for (Map.Entry<Direction, Node> entry : nodes.entrySet()) {
            if (entry.getValue().getNeighbours().size() == 0) entry.getValue().connect();
        }
    }

    public Map<Direction, Node> getNodes() {
        return Collections.unmodifiableMap(nodes);
    }

    public boolean canConnectTo(Tile neighbourTile) {
        Direction directionToNeighbour = position.directionTo(neighbourTile.getPosition());
        if (directionToNeighbour == null) return false;
        return nodes.get(directionToNeighbour).type == neighbourTile.getNodes().get(directionToNeighbour.opposite()).type;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }


}
