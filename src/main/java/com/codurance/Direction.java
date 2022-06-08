package com.codurance;

public enum Direction {

    NORTH("N", "W", "E"),
    EAST("E", "N", "S"),
    SOUTH("S", "E", "W"),
    WEST("W", "S", "N");

    private final String value;
    private final String left;
    private final String right;

    Direction(String value, String left, String right) {

        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Direction right() {
        return directionToThe(right);
    }

    public Direction left() {
        return directionToThe(left);
    }

    private Direction directionToThe(String rotateTo) {
        for (Direction direction : values()) {
            if (rotateTo.equals(direction.value)) {
                return direction;
            }
        }
        return Direction.NORTH;
    }

    public String value() {
        return value;
    }

}
