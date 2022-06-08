package com.codurance;

class Rover {

    String direction = "N";

    String execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                direction = rotateRight();
            } else {
                direction = "W";
            }
        }
        return "0:0:" + direction;
    }

    private String rotateRight() {
        switch (direction) {
            case "N":
                return "E";
            case "E":
                return "S";
            case "S":
                return "W";
            case "W":
            default:
                return "N";
        }
    }
}
