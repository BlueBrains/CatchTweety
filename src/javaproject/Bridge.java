package javaproject;

import java.awt.Point;

/**
 *
 * @author Molham
 */
public class Bridge extends Path {

    boolean bridgeUsed;
    boolean underBridgeUsed;
    int bridgeColor = -1;

    /**
     * build new bridge cell with the specified coordinates
     *
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Bridge(int x, int y) {
        super(x, y, false);
    }

    /**
     * mark the bridge as visited so no one can use it
     *
     * @param bridgeUsed value to assign it to bridgeUsed attribute
     */
    public void setBridgeUsed(boolean bridgeUsed) {
        this.bridgeUsed = bridgeUsed;
        if (underBridgeUsed && bridgeUsed) {
            setVisited(true);
        } else {
            setVisited(false);
        }
    }

    /**
     * mark under bridge as visited so no one can use it
     *
     * @param underBridgeUsed value to assign it to underbridgeUsed attribute
     */
    public void setUnderBridgeUsed(boolean underBridgeUsed) {
        this.underBridgeUsed = underBridgeUsed;
        if (underBridgeUsed && bridgeUsed) {
            setVisited(true);
        } else {
            setVisited(false);
        }
    }

    /**
     * check if bridge used
     *
     * @return true if yes , false if not
     */
    public boolean isBridgeUsed() {
        return bridgeUsed;
    }

    /**
     * check if under bridge used
     *
     * @return true if yes , false if not
     */
    public boolean isUnderBridgeUsed() {
        return underBridgeUsed;
    }

    /**
     * get the bridge color
     *
     * @return bridge color
     */
    public int getBridgeColor() {
        return bridgeColor;
    }

    /**
     * set the bridge color
     *
     * @param bridgeColor the value to assign it to bridgeColor attribute
     */
    public void setBridgeColor(int bridgeColor) {
        this.bridgeColor = bridgeColor;
    }

    @Override
    public void calledWithDrag(Point firstPoint, Point lastPoint, Controller control) {
        if ((this.x == lastPoint.x && this.y != lastPoint.y) && (control.myArray[firstPoint.x][firstPoint.y].visited)) {
            if (this.bridgeUsed && !this.equals(control.myArray[lastPoint.x][lastPoint.y])) {
                if (this.getBridgeColor() == control.myArray[lastPoint.x][lastPoint.y].getColor()) {
                    control.clearPath(this.bridgeColor, this);
                    lastPoint.x = this.getX();
                    lastPoint.y = this.getY();
                } else {
                    control.arraysOfPaths.get(bridgeColor).remove(this);
                    this.setBridgeUsed(false);
                    control.unClosedPath(bridgeColor);
                    this.bridgeColor = -1;
                }
            } else {
                this.setBridgeUsed(true);
                this.bridgeColor = control.myArray[lastPoint.x][lastPoint.y].getColor();
                control.arraysOfPaths.get(this.bridgeColor).add(this);
                lastPoint.x = this.getX();
                lastPoint.y = this.getY();
            }
        } else if ((this.y == lastPoint.y && this.x != lastPoint.x) && (control.myArray[firstPoint.x][firstPoint.y].visited)) {
            if (this.underBridgeUsed) {
                if (this.getColor() == control.myArray[lastPoint.x][lastPoint.y].getColor()) {
                    control.clearPath(this.color, this);
                    lastPoint.x = this.getX();
                    lastPoint.y = this.getY();
                } else {
                    control.arraysOfPaths.get(color).remove(this);
                    this.setUnderBridgeUsed(false);
                    control.unClosedPath(color);
                    this.color = -1;
                }
            } else {
                this.setUnderBridgeUsed(true);
                this.color = control.myArray[lastPoint.x][lastPoint.y].getColor();
                control.arraysOfPaths.get(this.color).add(this);
                lastPoint.x = this.getX();
                lastPoint.y = this.getY();
            }
        }
    }

    @Override
    public void calledWithPressed(Point lastPoint, Controller control) {
        if (this.bridgeUsed) {
            control.unClosedPath(this.bridgeColor);
            control.clearPath(this.bridgeColor, this);
            lastPoint.x = this.getX();
            lastPoint.y = this.getY();
        } else if (this.underBridgeUsed) {
            control.unClosedPath(this.color);
            control.clearPath(this.color, this);
            lastPoint.x = this.getX();
            lastPoint.y = this.getY();
        }
    }
}
