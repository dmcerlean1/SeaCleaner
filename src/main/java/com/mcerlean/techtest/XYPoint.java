package com.mcerlean.techtest;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Class representing a point in 2D graph. Currently only
 * allows positive numbers for coordinates.
 */
public class XYPoint {

    @Positive(message = "Positive numbers only please")
    private int x;
    @Positive(message = "Positive numbers only please")
    private int y;

    public XYPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @JsonCreator
    public XYPoint(@Size(min = 2, max = 2, message = "area size must be two positive integers") List<Integer> apiArgs)
    {
        this(apiArgs.get(0), apiArgs.get(1));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
