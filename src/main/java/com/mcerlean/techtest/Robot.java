package com.mcerlean.techtest;

import java.util.List;

/**
 * The Cleaning Robot
 */
public class Robot {

    private final Navigator navigator;
    private int oilPatchesCleaned;
    private List<Direction> cleaningInstructions;

    public Robot(Navigator navigator, List<Direction> instructions) {
        this.navigator = navigator;
        this.oilPatchesCleaned = navigator.isStartingInOilPatch()? 1 : 0;
        this.cleaningInstructions = instructions;
    }

    /**
     * Go through each instruction, keeping track of any patches
     * cleaned.
     * @return a CleaningReport detailing where I am and what I've cleaned
     */
    public CleaningReport clean(){
        oilPatchesCleaned += (int) cleaningInstructions.stream()
                .filter(navigator::move)
                .count();
        return new CleaningReport(oilPatchesCleaned, navigator.whereAmI());
    }
}
