package javaproject;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Molham
 */
public abstract class Cell implements Serializable {

    int x;
    int y;
    boolean visited;

    /**
     * build new cell with the selected coordinate
     *
     * @param x
     * @param y
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * build new cell with the selected coordinate and set the visited value
     *
     * @param x
     * @param y
     * @param visited
     */
    public Cell(int x, int y, boolean visited) {
        this.x = x;
        this.y = y;
        this.visited = visited;
    }

    /**
     * get x coordinate
     *
     * @return X
     */
    public int getX() {
        return x;
    }

    /**
     * set x coordinate
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set y coordinate
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * get y coordinate
     *
     * @return Y
     */
    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * check if this cell equal the passed cell according to coordinate
     *
     * @param obj the passed cell
     * @return true if equaled false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cell other = (Cell) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    /**
     * return the color of this cell
     *
     * @return
     */
    public abstract int getColor();

    /**
     * implement this function while mouse is dragged over cells which handling
     * the various cases that can happen when mouse is dragged
     *
     * @param firstPoint the point where the event has triggered
     * @param lastPoint the last visited point form the mouse dragging or
     * pressing events
     * @param control
     */
    public abstract void calledWithDrag(Point firstPoint, Point lastPoint, Controller control);

    /**
     * implement this function when mouse is pressed over a cell which handling
     * the various cases that can happen when mouse is pressed
     *
     * @param lastPoint the last visited point form the mouse dragging or
     * pressing events
     * @param control
     */
    public abstract void calledWithPressed(Point lastPoint, Controller control);
}
