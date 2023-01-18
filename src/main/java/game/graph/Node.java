package game.graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Node {
    private static int maxId = 0;

    public final NodeType type;
    public final int id;
    private boolean isDangling = true;

    private final List<Node> neighbours = new LinkedList<>();

    public Node(NodeType type) {
        this.type = type;
        this.id = maxId;
        maxId++;
    }

    public void addNeighbours(List<Node> neighbours) {
        this.neighbours.addAll(neighbours);
    }

    public boolean isDangling() {
        return isDangling;
    }

    public void connect() {
        isDangling = false;
    }

    public void addNeighbours(Node neighbour) {
        this.neighbours.add(neighbour);
    }

    public List<Node> getNeighbours() {
        return Collections.unmodifiableList(neighbours);
    }

}
