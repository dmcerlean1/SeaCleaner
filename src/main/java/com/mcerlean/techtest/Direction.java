package com.mcerlean.techtest;

/**
 * Enum representing directions of travel, currently limited to
 * North, East, South, and West.
 */
public enum Direction {

    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    int x;
    int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Direction valueOf(char character){
        Direction d;
        switch (character) {
            case 'N':
            case'n':
                d = NORTH;
                break;
            case 'E':
            case 'e':
                d = EAST;
                break;
            case 's':
            case 'S':
                d = SOUTH;
                break;
            case'W':
            case 'w':
                d = WEST;
                break;
            default: d = null;
        }
        return d;
    }
}
