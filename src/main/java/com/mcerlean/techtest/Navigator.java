package com.mcerlean.techtest;

import java.util.List;

/**
 * The robots "navigator" - responsible for navigating the sea.
 * Has a sensor for detecting any cleaned patches.
 */
public class Navigator {

    /**
     * 2-D map of the sea. A point will be if that patch is dirty,
     * false otherwise
     */
    private final boolean[][] seaMap;

    /**
     * Where are we now
     */
    private final XYPoint currentPoint;

    public Navigator(boolean[][] seaMap, XYPoint startingPoint, List<XYPoint> oilPatches) {
        this.seaMap = seaMap;
        this.currentPoint = startingPoint;
        makeMess(oilPatches);
    }

    /**
     * Move in a direction
     * @param direction - the direction to move
     * @return true if we've cleaned something, false otherwise
     */
    public boolean move(Direction direction) {

        int currentX = currentPoint.getX();
        int adjustX = direction.getX();
        if(currentX + adjustX > seaMap[0].length - 1){
            // shouldn't happen
            currentPoint.setX(seaMap[0].length - 1);
        } else if (currentX + adjustX < 0) {
            // also shouldn't happen
            currentPoint.setX(0);
        } else {
            currentPoint.setX(currentX + adjustX);
        }

        int currentY = currentPoint.getY();
        int adjustY = direction.getY();
        if(currentY + adjustY > seaMap.length - 1){
            // shouldn't happen
            currentPoint.setY(seaMap.length - 1);
        } else if (currentY + adjustY < 0) {
            // also shouldn't happen
            currentPoint.setY(0);
        } else {
            currentPoint.setY(currentY + adjustY);
        }

        if(seaMap[currentPoint.getY()][currentPoint.getX()]){
            seaMap[currentPoint.getY()][currentPoint.getX()] = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return the current position of the cleaning robot
     * @return XYPoint of current position
     */
    public XYPoint whereAmI(){
        return currentPoint;
    }

    /**
     * Given a list of coordinates, update the room
     * with where they are
     * @param oilPatches - where the oil patches are
     */
    private void makeMess(List<XYPoint> oilPatches) {
        oilPatches.forEach(point -> {
            if (point.getX() > seaMap[0].length - 1 || currentPoint.getX() < 0) {
                // ignore, probably log something
            } else if (point.getY() > seaMap.length - 1 || point.getY() < 0) {
                // ignore, log something
            } else {
                seaMap[point.getY()][point.getX()] = true;
            }
        });
    }

    /**
     * Are we starting in an oil patch?
     * @return true if we are, false otherwise
     */
    public boolean isStartingInOilPatch(){
        if(seaMap[currentPoint.getY()][currentPoint.getX()]){
            seaMap[currentPoint.getY()][currentPoint.getX()] = false;
            return true;
        } else {
            return false;
        }
    }
}
