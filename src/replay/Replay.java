package replay;

import javaproject.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Luay
 */
public class Replay {

    /*   Variabel   */
    String savedfilename;
    int time = 0;
    Timer t;
    int Step;
    ArrayList<ArrayList<Cell>> ArraysOfPaths;
    public ArrayList<Cell> BaseArray = new ArrayList<>();
    Cell Matrix[][];

    /**
     * **********************************************************
     */
    public Replay() {
    }

    /**
     *
     * @param FileName : Type (String) Contains The Name Of file you want to
     * save
     * @param Manage : Type (Controller) Contains player moves this Function
     * intialaize Object "SavedGame Type" and calls inner Function Called
     * writeEmpBinaryFile() to save the file
     * @throws IOException
     */
    public void set_savedGame(String FileName, Controller Manage) throws IOException {
        writeBinaryFile(FileName, new SavedGame(Manage));
    }

    /**
     *
     * @param fileName :Type (String) Contains The Name Of file you want to save
     * @param SavedGame : Type (SavedGame) Contains All you want To Load your
     * Save Game
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void writeBinaryFile(String fileName, SavedGame SavedGame) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName))));
        oos.writeObject(SavedGame);

        oos.flush();
        oos.close();
    }

    /**
     *
     * @param fileName:Type (String) Contains The Name Of file you want to read
     * @return SavedGame (Type) : read binaryFile and return it
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static SavedGame readBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in;
        SavedGame Sgame = new SavedGame(null, null);
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            SavedGame Savegame = (SavedGame) in.readObject();
            return Savegame;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("class Not Found tooooooooooot");
        }
        return Sgame;
    }
    public SavedGame savedGame;

    /**
     *
     * @param filename :Type (String) Contains The Name Of file you want to Load
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException this Function Build All Game Needs like
     * time , step , ArrayOfPaths: that Contains playerMoved , BaseArray : that
     * Contains Stage prepartories this Function assign that parameters From
     * binaryFile"GameSavedType" by Called the Function readBinaryFile() also
     * this function fill the array of paths by Called Function
     * MatrixBuilder(ArraysOfPaths);
     */
    public void BuildGame(String filename) throws IOException, FileNotFoundException, ClassNotFoundException {
        savedfilename = filename;

        savedGame = readBinaryFile(savedfilename);
        time = savedGame.Manage.timer;
        Step = savedGame.Manage.getNumberofStep();
        ArraysOfPaths = savedGame.Manage.getArraysOfPaths();
        BaseArray = savedGame.getBaseArray();
        Matrix = new Cell[savedGame.Manage.stage + 4][savedGame.Manage.stage + 4];
        MatrixBuilder(ArraysOfPaths);
    }

    /**
     *
     * @param allpaths : ArrayList<ArrayList<Cell>> contains Paths that player
     * has played and the index of big array determine color this Function
     * Called function to draw each path
     */
    public void MatrixBuilder(ArrayList<ArrayList<Cell>> allpaths) {
        for (int i = 0; i < ArraysOfPaths.size() - 1; i++) {
            Pathdrawer(allpaths.get(i));
        }
    }

    /**
     *
     * @param Path : ArrayList<Cell> Fill the color path in big array
     */
    public void Pathdrawer(ArrayList<Cell> Path) {
        for (Cell cell : Path) {
            Matrix[cell.getX()][cell.getY()] = cell;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

    }
}
