package game.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Edge {
    private final List<Node> nodes = new ArrayList<>();

    public Edge(Node node1, Node node2) {
        nodes.add(node1);
        nodes.add(node2);
    }

    public List<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }
}
