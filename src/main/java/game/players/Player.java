package game.players;

public class Player {
    public final PlayerColor color;
    private int availableMeeples = 7;
    private int points = 0;

    public Player(PlayerColor color) {
        this.color = color;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public boolean hasAvailableMeeples() {
        return availableMeeples > 0;
    }

    public void placeMeeple() {
        availableMeeples--;
    }

    public void returnMeeples(int amount) {
        availableMeeples += amount;
    }
}
