package game.graph;

import java.util.HashSet;
import java.util.Set;

public class DFSTraverser {
    private final Set<Node> visited = new HashSet<>();

    public boolean isGraphComplete(Node node) {
        visited.add(node);
        if (node.isDangling()) return false;
        for (Node neighbour : node.getNeighbours()) {
            if (!visited.contains(neighbour) && !isGraphComplete(neighbour)) return false;
        }
        return true;
    }
}
