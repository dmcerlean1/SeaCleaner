package com.mcerlean.techtest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY;

/**
 * Class to hold the programme instructions
 */
public class Instructions {

    private final XYPoint areaSize;

    private final XYPoint startingPosition;

    @Size(min = 1, message = "Please provide at least on cleaning instruction")
    @JsonFormat(with = ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private final List<XYPoint> oilPatches;

    @Pattern(regexp = "^[NnEeSsWw]+$", message = "Directions must be one of N,E,S,W (case insensitive)")
    private final String navigationInstructions;

    @JsonIgnore
    private final List<Direction> directions;

    public Instructions(XYPoint areaSize, XYPoint startingPosition,
                        List<XYPoint> oilPatches, String navigationInstructions) {
        this.areaSize = areaSize;
        this.startingPosition = startingPosition;
        this.oilPatches = oilPatches;
        this.navigationInstructions = navigationInstructions;
        this.directions = getDirectionsFromString(navigationInstructions);
    }

    private List<Direction> getDirectionsFromString(String navigationInstructions) {
        return navigationInstructions.chars().mapToObj(i -> (char) i)
                .map(Direction::valueOf)
                .collect(Collectors.toList());
    }

    public XYPoint getAreaSize() {
        return areaSize;
    }

    public XYPoint getStartingPosition() {
        return startingPosition;
    }

    public List<XYPoint> getOilPatches() {
        return oilPatches;
    }

    public String getNavigationInstructions() {
        return navigationInstructions;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    /**
     * Validate the directions won't take us out of bounds
     * @return true if the instructions are valid (i.e. keep us within range,
     * false otherwise)
     */
    @AssertTrue(message = "The supplied directions will send the robot out of range")
    boolean isValidDirections() {
        int x = startingPosition.getX();
        int y = startingPosition.getY();
        for (Direction d : directions){
            x += d.getX();
            y += d.getY();
            if(x > areaSize.getX() || y > areaSize.getY()){
                return false;
            }
        }
        return true;
    }
}
