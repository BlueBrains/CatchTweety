/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package score;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author falcon
 */
public class addScore {

    String msg, step, Newname;
    int NumberOfStep = 0, stage = 0, time = 0;
    ArrayList<Player> NewArray = new ArrayList<Player>();
    ArrayList<Player> player;

    public addScore(String s, int step, int stage, int time) {
        msg = s;
        this.time = time;
        NumberOfStep = step;

        this.stage = stage;
        EndGame();
    }

    /**
     * the function save Best Ten Player in text file (PlayerFile)
     */
    private void EndGame() {
        Newname = "BestPlayer\\" + stage + "\\PlayerFile.txt";
        try {
            File f = new File(Newname);
            if (f.exists()) {
                player = readEmpTextFile("BestPlayer\\" + stage + "\\PlayerFile.txt");
                if (player.size() < 11) {
                    msg = javax.swing.JOptionPane.showInputDialog("please  enter  your name ");
                    Player NewPlayer = new Player(msg, NumberOfStep, time);
                    player.add(NewPlayer);
                } else {
                    if (time < player.get(player.size() - 1).getTime()) {
                        player.remove(player.get(player.size() - 1));
                        msg = javax.swing.JOptionPane.showInputDialog("please  enter  your name ");
                        Player NewPlayer = new Player(msg, NumberOfStep, time);
                        player.add(NewPlayer);

                    } else if (time == player.get(player.size() - 1).getTime()) {
                        if (NumberOfStep >= player.get(player.size() - 1).getNumberOfStep()) {
                            player.remove(player.get(player.size() - 1));
                            msg = javax.swing.JOptionPane.showInputDialog("please  enter  your name ");
                            Player NewPlayer = new Player(msg, NumberOfStep, time);
                            player.add(NewPlayer);
                        }

                    }
                }
            } else {
                msg = javax.swing.JOptionPane.showInputDialog("please  enter  your name ");
                Player NewPlayer = new Player(msg, NumberOfStep, time);
                player = new ArrayList<Player>();
                player.add(NewPlayer);
            }

            Collections.sort(player);

            writePlayerFile("BestPlayer\\" + stage + "\\PlayerFile.txt");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(addScore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(addScore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Player> readEmpTextFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<Player> ply = new ArrayList<Player>();
        Reader reader = new FileReader(fileName);

        BufferedReader br = new BufferedReader(reader);
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            StringTokenizer st = new StringTokenizer(line, "|");
            try {
                while (st.hasMoreElements()) {

                    String name = st.nextToken();
                    int time = Integer.parseInt(st.nextToken());
                    int step = Integer.parseInt(st.nextToken());
                    ply.add(new Player(name, step, time));
                }
            } catch (Exception e) {
            }
        }
        return ply;
    }

    public void writePlayerFile(String fileName) throws IOException {
        Writer writer = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(writer);
        for (int i = 0; i < player.size(); i++) {
            bw.write(player.get(i).getName() + "|" + player.get(i).getTime() + "|" + player.get(i).getNumberOfStep() + "\r\n");
        }
        bw.flush();
        writer.close();
    }

}
