package javaproject;

import java.awt.Point;

/**
 *
 * @author Molham
 */
public class Hull extends Path {

    /**
     * build new Hull with the specified coordinates
     *
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Hull(int x, int y) {
        super(x, y, false);
    }

    @Override
    public void calledWithDrag(Point firstPoint, Point lastPoint, Controller control) {
        lastPoint.x = this.getX();
        lastPoint.y = this.getY();
    }

    @Override
    public void calledWithPressed(Point lastPoint, Controller control) {
        lastPoint.x = this.getX();
        lastPoint.y = this.getY();
    }
}
