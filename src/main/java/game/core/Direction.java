package game.core;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
        };
    }

    public Vector toUnitVector() {
        return switch (this) {
            case NORTH  -> new Vector(0, -1);
            case EAST  -> new Vector(1, 0);
            case SOUTH  -> new Vector(0, 1);
            case WEST  -> new Vector(-1, 0);
        };
    }
}
