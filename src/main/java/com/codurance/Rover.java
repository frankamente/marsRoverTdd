package com.codurance;

class Rover {

    private final Grid grid;

    private Direction direction;
    private Coordinate coordinate;

    Rover(Grid grid) {
        this.grid = grid;
        direction = Direction.NORTH;
        coordinate = new Coordinate(0, 0);
    }

    String execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                direction = direction.right();
            } else if (command == 'L') {
                direction = direction.left();
            } else {
                coordinate = grid.nextCoordinateFor(coordinate, direction);
            }
        }
        return coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }
}
