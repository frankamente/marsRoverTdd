package com.codurance;

class Rover {


    Direction direction = Direction.NORTH;

    String execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                direction = direction.right();
            } else {
                direction = direction.left();
            }
        }
        return "0:0:" + direction.value();
    }
}
