package javaproject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Molham
 */
public class Controller implements Serializable {

    private boolean[] arrayOfTrueEnd;
    public ArrayList<ArrayList<Cell>> arraysOfPaths;
    public Cell[][] myArray;
    public int level;
    public int stage;
    public int numberofStep;
    public int timer;
    public int previousColor = -2;

    /**
     * build new Controller with the selected level and stage
     *
     * @param level number of level passed from player
     * @param stage number of stage passed from player
     */
    public Controller(int level, int stage) {
        initialize(stage);
        this.level = level;
        this.stage = stage;
        fillMyArray(level, stage);

    }

    /**
     * initialize the data member according to the specified game
     *
     * @param stage the number of stage used for initializing the arrays in
     * controller
     */
    private void initialize(int stage) {
        arrayOfTrueEnd = new boolean[stage + 4];
        arraysOfPaths = new ArrayList<ArrayList<Cell>>(stage + 4);
        for (int i = 0; i < stage + 4; i++) {
            arraysOfPaths.add(new ArrayList<Cell>());
        }
    }

    /**
     * get the game from the file
     *
     * @param level level number
     * @param stage stage number
     * @return the game as ArrayList<Cell>
     */
    private ArrayList<Cell> fetchGame(int level, int stage) {
        String fileName = "gameResources\\Stage" + stage + "\\" + level + ".bin";
        System.out.println(fileName);
        ObjectInputStream in;
        ArrayList<Cell> fetchedGame = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            fetchedGame = (ArrayList<Cell>) in.readObject();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("class Not Found ");
        }
        return fetchedGame;
    }

    /**
     * fill myArray from the fetched game
     *
     * @param level level number
     * @param stage stage number
     */
    public void fillMyArray(int level, int stage) {

        myArray = new Cell[stage + 4][stage + 4];
        ArrayList<Cell> fetchedGame = fetchGame(level, stage);
        for (Cell cell : fetchedGame) {
            myArray[cell.getX()][cell.getY()] = cell;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="method Based on Amer Files">
//    private ArrayList<Item> fetchGame(int level, int stage) {
//        String fileName = "gameResources\\Stage" + stage + "\\" + level + ".bin";
//        System.out.println(fileName);
//        ObjectInputStream in;
//        ArrayList<Item> fetchedGame = null;
//        try {
//            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
//            fetchedGame = (ArrayList<Item>) in.readObject();
//        } catch (IOException ex) {
//            System.err.println(ex.getMessage());
//        } catch (ClassNotFoundException ex) {
//            System.err.println("class Not Found tooooooooooot");
//        }
//        return fetchedGame;
//    }
//    public void fillMyArray(int level, int stage) {
//        
//        myArray = new Cell[stage + 4][stage + 4];
//        ArrayList<Item> fetchedGame = fetchGame(level, stage);
//        for (Item cell : fetchedGame) {
//            switch (cell.getType()) {
//                case "*":
//                    myArray[cell.getI()][cell.getJ()] = new Hull(cell.getI(), cell.getJ());
//                    break;
//                case "#":
//                    myArray[cell.getI()][cell.getJ()] = new Bridge(cell.getI(), cell.getJ());
//                    break;
//                default:
//                    int color = Integer.parseInt(cell.getType());
//                    myArray[cell.getI()][cell.getJ()] = new Node(color, cell.getI(), cell.getJ());
//                    break;
//            }
//        }
//        for (int i = 0; i < myArray.length; i++) {
//            for (int j = 0; j < myArray.length; j++) {
//                if (myArray[i][j] == null) {
//                    myArray[i][j] = new Path(i, j);
//                }
//            }
//        }
//    }
// </editor-fold>
    /**
     * get the array of paths
     *
     * @return arrays of paths
     */
    public ArrayList<ArrayList<Cell>> getArraysOfPaths() {
        return arraysOfPaths;
    }

    /**
     * set the array of paths
     *
     * @param arraysOfPaths
     */
    public void setArraysOfPaths(ArrayList<ArrayList<Cell>> arraysOfPaths) {
        this.arraysOfPaths = arraysOfPaths;
    }

    /**
     * clear cells after cell "me" in the path whose color is "color"
     *
     * @param color color of path want to clear it
     * @param me clear everything after this cell
     */
    public void clearPath(int color, Cell me) {

        for (Iterator<Cell> it = arraysOfPaths.get(color).iterator(); it.hasNext();) {
            if (it.next().equals(me)) {
                for (Iterator<Cell> i = it; i.hasNext();) {
                    Cell thisCell = i.next();
                    thisCell.visited = false;
                    if (thisCell instanceof Bridge) {
                        if (((Bridge) thisCell).getBridgeColor() == color) {
                            ((Bridge) thisCell).setBridgeUsed(false);
                            ((Bridge) thisCell).setBridgeColor(-1);
                        } else {
                            ((Bridge) thisCell).setUnderBridgeUsed(false);
                            ((Bridge) thisCell).setColor(-1);
                        }
                    } else if (thisCell instanceof Path) {
                        ((Path) thisCell).setColor(-1);
                    }
                    i.remove();
                }
                break;
            }
        }

    }

    /**
     * clear all path whose color is "color"
     *
     * @param color color of path want to clear it
     */
    public void clearAllPath(int color) {
        for (Iterator<Cell> it = arraysOfPaths.get(color).iterator(); it.hasNext();) {
            Cell thisCell = it.next();
            thisCell.visited = false;
            if (thisCell instanceof Path) {
                ((Path) thisCell).setColor(-1);
            }
            it.remove();
        }
    }

    /**
     * check if game finished or not
     *
     * @return true if finished false if not
     */
    public boolean isGameFinished() {
        int i = 1;
        boolean win = true;
        while (i < arrayOfTrueEnd.length) {
            if (!arrayOfTrueEnd[i]) {
                return false;
            }
            i++;
        }
        return win;
    }

    /**
     * mark this path as completed path
     *
     * @param color the color of the path which completed
     */
    public void closedPath(int color) {
        arrayOfTrueEnd[color] = true;

    }

    /**
     * mark this pah as uncompleted path
     *
     * @param color the color of the path which uncompleted
     */
    public void unClosedPath(int color) {
        arrayOfTrueEnd[color] = false;
    }

    /**
     * check if all valid cells in myArray have been visited
     *
     * @return true if yes false if not
     */
    public boolean checkOptimality() {
        boolean visitedAll = true;
        for (int i = 0; i < stage + 4; i++) {
            for (int j = 0; j < stage + 4; j++) {
                if (myArray[i][j] instanceof Path) {
                    if (myArray[i][j] instanceof Bridge) {
                        visitedAll = visitedAll & myArray[i][j].visited;
                    } else if (myArray[i][j] instanceof Hull) {
                    } else {
                        visitedAll = visitedAll & myArray[i][j].visited;
                    }
                }

            }
        }

        return visitedAll;
    }

    /**
     * get number of steps which player has moved it while playing
     *
     * @return number of steps
     */
    public int getNumberofStep() {
        return numberofStep;
    }

    public static void main(String[] args) {
        Controller c = new Controller(1, 1);
    }

}

// <editor-fold defaultstate="collapsed" desc="method from Class Management we may use it ">
/////////////////////////////////////////////////////////////////////
//    public void addOneEnd(int i , ArrayList < Cell_base > path)
//    {
//            if ( (path.get(0).x != path.get(path.size()-1).x)&(path.get(0).y != path.get(path.size()-1).y))
//            {
//              ArrayOfTrueEnd.add(i,true);
//            }
//    }
//    public boolean CheckEnd(int i , Node n)
//    {
//     if (n.color == i)
//         return true;
//     return false;            
//    }
//        public void deleteTrueEnd ( int i)
//    {
//       ArrayOfTrueEnd.remove(i);
//    }
//        
//     public void  deleteSpecificPath(int color ,Cell_base cell)
//    {
//        int i = color;
//               switch (i)
//                {
//                case 1 : {
//                            int Firstindex= Path1.indexOf(cell);
//                            for (int l=Firstindex;l<Path1.size();l++)
//                                     Path1.remove(l);
//                
//                            break;}
//                case 2 : {
//                            int Firstindex= Path2.indexOf(cell);
//                                    for (int l=Firstindex;l<Path2.size();l++)
//                                             Path2.remove(l);
//
//                            break;}
//                case 3 : {
//                            int Firstindex= Path3.indexOf(cell);
//                                    for (int l=Firstindex;l<Path3.size();l++)
//                                             Path3.remove(l);
//
//                            break;}
//                case 4 : {
//                            int Firstindex= Path4.indexOf(cell);
//                                    for (int l=Firstindex;l<Path4.size();l++)
//                                             Path4.remove(l);
//
//                            break;}
//                case 5 : {
//                            int Firstindex= Path5.indexOf(cell);
//                                 for (int l=Firstindex;l<Path5.size();l++)
//                                          Path5.remove(l);
//
//                            break;}
//                case 6 : {
//                            int Firstindex= Path6.indexOf(cell);
//                                    for (int l=Firstindex;l<Path6.size();l++)
//                                             Path6.remove(l);
//
//                            break;}
//                case 7 : {
//                            int Firstindex= Path7.indexOf(cell);
//                                    for (int l=Firstindex;l<Path7.size();l++)
//                                             Path7.remove(l);
//
//                            break;}
//                case 8 : {
//                            int Firstindex= Path8.indexOf(cell);
//                                    for (int l=Firstindex;l<Path8.size();l++)
//                                             Path8.remove(l);
//
//                            break;}
//                
//                }
//               deleteTrueEnd(i);
//    }
//
//}
// </editor-fold>
