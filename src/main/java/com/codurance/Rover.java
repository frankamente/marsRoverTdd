package com.codurance;

class Rover {

    public static int MAX_HEIGHT = 10;
    Direction direction = Direction.NORTH;
    private Coordinate coordinate = new Coordinate(0, 0);

    String execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                direction = direction.right();
            } else if (command == 'L') {
                direction = direction.left();
            } else {
                coordinate = move(direction);
            }
        }
        return coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }


    public Coordinate move(Direction direction) {
        int x = coordinate.x();
        int y = coordinate.y();
        if (direction == Direction.NORTH) {
            y = (y + 1) % MAX_HEIGHT;
        }
        if (direction == Direction.EAST) {
            x++;
        }
        if (direction == Direction.SOUTH) {
            y--;
        }
        if (direction == Direction.WEST) {
            x--;
        }

        return new Coordinate(x, y);
    }
}
