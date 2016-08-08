package javaproject;

import java.awt.Point;

/**
 *
 * @author Molham
 */
public class Node extends Cell {

    final int color;

    /**
     * build new node with the specified coordinate and set node color
     *
     * @param color node color
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Node(int color, int x, int y) {
        super(x, y, false);
        this.color = color;
    }

    @Override
    public void calledWithPressed(Point lastPoint, Controller control) {
        if (this.visited) {
            control.clearPath(this.color, this);
            control.unClosedPath(color);
//                control.arraysOfPaths.get(color).add(this);
        } else {
            control.clearAllPath(color);
            control.unClosedPath(color);
            control.arraysOfPaths.get(color).add(this);
            this.visited = true;
        }
        lastPoint.x = this.getX();
        lastPoint.y = this.getY();
    }

    @Override
    public void calledWithDrag(Point firstPoint, Point lastPoint, Controller control) {
        if ((this.x == lastPoint.x || this.y == lastPoint.y) && (control.myArray[firstPoint.x][firstPoint.y].visited)) {
            if (control.myArray[lastPoint.x][lastPoint.y] instanceof Bridge && lastPoint.x == this.getX()) {
                if (!this.visited && ((Bridge) control.myArray[lastPoint.x][lastPoint.y]).getBridgeColor() == this.color) {
                    control.arraysOfPaths.get(color).add(this);
                    control.closedPath(color);
                    this.visited = true;
                }
            } else if (!this.visited && control.myArray[lastPoint.x][lastPoint.y].getColor() == this.color) {
                control.arraysOfPaths.get(color).add(this);
                control.closedPath(color);
                this.visited = true;
            }
        }
    }

    @Override
    public int getColor() {
        return color;
    }

}
