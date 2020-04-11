package com.mcerlean.techtest;

/**
 * Factory class for generating Navigator objects. Reads the instructions
 * and creates the Robot.
 */
public class RobotFactory {

    /**
     * Get a Robot ready to perform it's instructions
     * @param instructions valid instructions
     * @return Robot object
     */
    static Robot getRobot(Instructions instructions){

        var roomDimensions = instructions.getAreaSize();
        boolean[][] room = new boolean[roomDimensions.getY()][roomDimensions.getX()];
        var navigator = new Navigator(room, instructions.getStartingPosition(), instructions.getOilPatches());
        return new Robot(navigator, instructions.getDirections());
    }
}
