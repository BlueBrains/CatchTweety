package javaproject;

import java.awt.Point;

/**
 *
 * @author Molham
 */
public class Path extends Cell {

    int color = -1;

    /**
     * build new path cell with the specified coordinates
     *
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Path(int x, int y) {
        super(x, y, false);
    }

    /**
     * build new path cell with the specified coordinates and set the visited
     * value
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @param visited visiting value for this path
     */
    public Path(int x, int y, boolean visited) {
        super(x, y, visited);
    }

    /**
     * set the visited value to the visited attribute
     *
     * @param visited
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public int getColor() {
        return color;
    }

    /**
     * set the path color
     *
     * @param color color to assign it to path color attribute
     */
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void calledWithDrag(Point firstPoint, Point lastPoint, Controller control) {
        if ((this.x == lastPoint.x || this.y == lastPoint.y) && (control.myArray[firstPoint.x][firstPoint.y].visited)) {
            if (this.visited) {
                if (control.myArray[lastPoint.x][lastPoint.y] instanceof Bridge && lastPoint.x == this.getX()) {
                    if (this.getColor() == ((Bridge) control.myArray[lastPoint.x][lastPoint.y]).getBridgeColor()) {
                        control.clearPath(this.color, this);
                        lastPoint.x = this.getX();
                        lastPoint.y = this.getY();
                    } else {
                        control.clearPath(this.color, this);
                        control.arraysOfPaths.get(color).remove(this);
                        this.visited = false;
                        control.unClosedPath(color);
                        this.color = -1;
                    }
                } else if (this.getColor() == control.myArray[lastPoint.x][lastPoint.y].getColor()) {
                    control.clearPath(this.color, this);
                    lastPoint.x = this.getX();
                    lastPoint.y = this.getY();
                } else {
                    control.clearPath(this.color, this);
                    control.arraysOfPaths.get(color).remove(this);
                    this.visited = false;
                    control.unClosedPath(color);
                    this.color = -1;
                }
            } else {
                this.visited = true;
                if (control.myArray[lastPoint.x][lastPoint.y] instanceof Bridge && lastPoint.x == this.getX()) {
                    this.color = ((Bridge) control.myArray[lastPoint.x][lastPoint.y]).getBridgeColor();
                } else {
                    this.color = control.myArray[lastPoint.x][lastPoint.y].getColor();
                }
                control.arraysOfPaths.get(this.color).add(this);
                lastPoint.x = this.getX();
                lastPoint.y = this.getY();
            }
        }
    }

    @Override
    public void calledWithPressed(Point lastPoint, Controller control) {
        if (this.visited) {
            control.clearPath(this.color, this);
            lastPoint.x = this.getX();
            lastPoint.y = this.getY();
        }
    }

}

//   crazy idea :P
//if (this.visited && !this.equals(control.myArray[lastPoint.x][lastPoint.y])) {
//                control.clearPath(this.color, this);
////                lastPoint.x = this.getX();
////                lastPoint.y = this.getY();
//                control.arraysOfPaths.get(color).remove(this);
//                this.visited = false;
//                control.unClosedPath(color);
//                this.color = -1;
//&& !this.equals(control.myArray[lastPoint.x][lastPoint.y])
