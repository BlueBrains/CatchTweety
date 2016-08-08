package javaproject;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Molham
 */
public class BuildNewGame {

    public static void writeEmpBinaryFile(String fileName) throws FileNotFoundException, IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName))));
        ArrayList<Cell> t = new ArrayList<Cell>();
        t.add(new Node(0, 0, 0));
        t.add(new Hull(0, 1));
        t.add(new Path(0, 2));
        t.add(new Path(0, 3));
        t.add(new Node(0, 0, 4));
        t.add(new Node(1, 1, 0));
        t.add(new Path(1, 1));
        t.add(new Path(1, 2));
        t.add(new Path(1, 3));
        t.add(new Path(1, 4));
        t.add(new Node(2, 2, 0));
        t.add(new Node(3, 2, 1));
        t.add(new Path(2, 2));
        t.add(new Node(3, 2, 3));
        t.add(new Path(2, 4));
        t.add(new Path(3, 0));
        t.add(new Path(3, 1));
        t.add(new Path(3, 2));
        t.add(new Path(3, 3));
        t.add(new Path(3, 4));
        t.add(new Node(2, 4, 0));
        t.add(new Node(1, 4, 1));
        t.add(new Node(4, 4, 2));
        t.add(new Path(4, 3));
        t.add(new Node(4, 4, 4));
        oos.writeObject(t);
        oos.flush();
        oos.close();

    }

    public static void main(String[] args) {
        try {    
            writeEmpBinaryFile("gameResources\\Stage" + 1 +"\\" + 2 + ".bin");
        } catch (IOException ex) {
            Logger.getLogger(BuildNewGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
