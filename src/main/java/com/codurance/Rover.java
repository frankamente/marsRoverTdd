package com.codurance;

import java.util.Optional;

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
        String obstacle = "";
        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                direction = direction.right();
            } else if (command == 'L') {
                direction = direction.left();
            } else {
                Optional<Coordinate> nextCoordinate =
                        grid.nextCoordinateFor(coordinate, direction);

                if (nextCoordinate.isPresent()) {
                    coordinate = nextCoordinate.get();
                } else {
                    obstacle = "O:";
                }
            }
        }
        return obstacle + coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }
}
