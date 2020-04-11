package com.mcerlean.techtest;

import java.util.List;

/**
 * A Cleaning Report - details where the bot finished
 * and how many patches of oil it cleaned
 */
public class CleaningReport {

    private final int[] finalPosition;
    private final int oilPatchesCleaned;

    public CleaningReport(int oilPatchesCleaned, XYPoint finalPosition) {
        this.oilPatchesCleaned = oilPatchesCleaned;
        this.finalPosition= new int[] {finalPosition.getX(), finalPosition.getY()};
    }

    /**
     * Implemented for Jackson to serialise
     * @return final poisiton of robot
     */
    public int[] getFinalPosition() {
        return finalPosition;
    }

    /**
     * Implemented for Jackson to serialise
     * @return number of oil patches cleaned
     */
    public int getOilPatchesCleaned() {
        return oilPatchesCleaned;
    }
}
