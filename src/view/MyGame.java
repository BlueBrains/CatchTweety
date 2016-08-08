/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaproject.Bridge;
import javaproject.Cell;
import javaproject.Controller;
import javaproject.Hull;
import javaproject.Node;
import javax.imageio.ImageIO;
import javax.swing.border.BevelBorder;
import replay.Replay;
import score.addScore;
import static sun.audio.AudioPlayer.player;

/**
 *
 * @author Molham
 */
public class MyGame extends javax.swing.JFrame {

    private Panel2 jPanel2;
//    private Controller control = new Controller(SelectLevel.numberOfLevel, SelectStage.NumberOfStage);    
//    private Controller control = new Controller(1, 1);
    private Controller control;
    private Point lastPoint = new Point();
    private Point firstPoint = new Point();
    private Point firstCell[] = new Point[8];
    private final int k = 50;
    private Timer t;
    private int time;
    private int minute = 0;
    int myColorPressed;
    private BufferedImage Selvester1[] = new BufferedImage[9];
    private BufferedImage Selvester2[] = new BufferedImage[9];
    boolean isSelvester;
    int xx[] = new int[8];
    private BufferedImage Tweety1[] = new BufferedImage[9];
    private BufferedImage Tweety2[] = new BufferedImage[9];
    int yy[] = new int[8];
    private BufferedImage Hull;
    private boolean selevesterUsed[] = new boolean[8];
//    private JLayeredPane lpane;

    /**
     * Creates new form NewJFrame
     */
    public MyGame() {

        control = new Controller(SelectLevel.numberOfLevel, SelectStage.NumberOfStage);
        initComponents();
        initPanel();
        intializeImages();
        this.setVisible(true);

        time = 0;

        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                time++;
                int y = time + (minute * 60);
                control.timer = y;

                if (time == 60) {
                    t.restart();
                    time = 0;
                    minute++;
                }
                jLabel1.setText(" " + minute + " : " + time + "");
            }
        });

        if (control.isGameFinished()) {
            t.stop();
        } else {
            t.start();
        }
    }

    public MyGame(int stage, int level) {

        control = new Controller(level, stage);
        initComponents();
        initPanel();
        intializeImages();
        time = 0;

        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                time++;
                int y = time + (minute * 60);
                control.timer = y;
                if (time == 60) {
                    t.restart();
                    time = 0;
                    minute++;
                }
                jLabel1.setText(" " + minute + " : " + time + "");
            }
        });

        if (control.isGameFinished()) {
            t.stop();
        } else {
            t.start();
        }
    }

    public MyGame(Replay c) {
        initComponents();
        intializeImages();
        control = c.savedGame.Manage;
        control.numberofStep = c.savedGame.Manage.numberofStep;
        jLabel4.setText(control.numberofStep+"");
        minute = c.savedGame.Manage.timer / 60;
        time = c.savedGame.Manage.timer % 60;
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                time++;
                int m = 0;
                jLabel1.setText("0 " + m + " : " + time + "");
                if (time == 59) {
                    m++;
                    time = 0;
                }

            }
        });

        if (control.isGameFinished()) {
            t.stop();
        } else {
            t.start();
        }
        control.level = c.savedGame.Manage.level;
        control.stage = c.savedGame.Manage.stage;
        initPanel();

    }

    private void intializeImages() {

        for (int i = 1; i < 9; i++) {
            xx[i - 1] = 1;
            yy[i - 1] = 1;
            firstCell[i - 1] = new Point();
            try {
                Selvester1[i] = ImageIO.read(new File("gameResources\\images\\S" + (i - 1) + ".png"));
                Selvester2[i] = ImageIO.read(new File("gameResources\\images\\SS" + (i - 1) + ".png"));
                Tweety1[i] = ImageIO.read(new File("gameResources\\images\\T" + (i - 1) + ".png"));
                Tweety2[i] = ImageIO.read(new File("gameResources\\images\\TT" + (i - 1) + ".png"));
            } catch (IOException ex) {
                Logger.getLogger(MyGame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        try {
            Hull = ImageIO.read(new File("gameResources\\images\\Hull.png"));
        } catch (IOException e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Game");
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );

        jPanel3.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("0");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel1);
        jLabel1.setBounds(170, 20, 60, 18);

        jLabel2.setText("<html>\n<B>Time</B>\n</html>");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(120, 20, 28, 14);

        jLabel3.setText("<html>\n<B>Steps</B>\n</html>");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(120, 50, 32, 14);

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("0");
        jLabel4.setToolTipText("");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel4);
        jLabel4.setBounds(170, 50, 60, 18);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/26667_788646853424ee6b9.png"))); // NOI18N
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 0, 100, 90);

        jMenu1.setText("File");

        jMenuItem1.setText("Save Game");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Load Game");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Best Score");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Exit To Main Menu");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Game");

        jMenuItem7.setText("New Level");
        jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem7MouseClicked(evt);
            }
        });
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem6.setText("Replay");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(266, 416));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked

    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //    gload = new GameLoader("SavedGame");
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                control.timer = (time)+(minute*60);
                
                new SaveGame(control).setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MouseClicked

    }//GEN-LAST:event_jMenuItem7MouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        SelectLevel level = new SelectLevel();
        level.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.setVisible(false);
        new MyGame().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    public void FormPathsDrawer() {

    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new LoadGame().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(LoadGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoadGame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Start_Page x = new Start_Page();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Score scoure = null;
        try {
            scoure = new Score();
        } catch (IOException ex) {
            Logger.getLogger(Start_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Start_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        scoure.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_jMenuItem4ActionPerformed
    private void initPanel() {

        this.setVisible(false);
        jPanel2 = new Panel2();
        jPanel2.setBackground(Color.GRAY);
        jPanel2.setBounds(0, 0, k * (control.stage + 4) + 1, k * (control.stage + 4) + 1);
        jPanel1.setPreferredSize(new Dimension(k * (control.stage + 4) + 10, k * (control.stage + 4) + 10));
        this.setPreferredSize(new Dimension(75 + k * (control.stage + 4), 180 + k * (control.stage + 4)));
        this.setLocation(465, 85);
        jPanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                firstPoint.y = Math.round(evt.getX() / k);
                firstPoint.x = Math.round(evt.getY() / k);
                int color = control.myArray[firstPoint.x][firstPoint.y].getColor();

                if (control.myArray[firstPoint.x][firstPoint.y] instanceof Node) {

                    myColorPressed = control.myArray[firstPoint.x][firstPoint.y].getColor();

                    if ((xx[myColorPressed] < 0) && (firstPoint.x == firstCell[myColorPressed].x) && (firstPoint.y == firstCell[myColorPressed].y)) {
                        xx[myColorPressed] = -xx[myColorPressed];
                    } else if (xx[myColorPressed] > 0) {
                        firstCell[myColorPressed].x = firstPoint.x;
                        firstCell[myColorPressed].y = firstPoint.y;
                    }
                }
                
                control.myArray[firstPoint.x][firstPoint.y].calledWithPressed(lastPoint, control);
                if (control.arraysOfPaths.get(color).size() > 1 &&control.arraysOfPaths.get(color).get(control.arraysOfPaths.get(color).size() -1) == control.myArray[firstPoint.x][firstPoint.y] &&control.myArray[firstPoint.x][firstPoint.y] instanceof Node){
                    control.arraysOfPaths.get(color).get(0).calledWithPressed(lastPoint, control);
                    
                }
                if(color != -1)
                    control.unClosedPath(color);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                if (control.previousColor != control.myArray[firstPoint.x][firstPoint.y].getColor()) {
                    control.numberofStep++;
                    control.previousColor = control.myArray[firstPoint.x][firstPoint.y].getColor();
                    jLabel4.setText(" " + control.numberofStep);
                }
                if (control.isGameFinished()) {
                    if (control.checkOptimality()) {
                        t.stop();
                        NextLevel next = new NextLevel(time, minute, control.getNumberofStep());
                        int y = time + (minute * 60);
                        addScore score = new addScore("Good Player", control.numberofStep, control.stage, y);
                    } else {
                        OOPs oops = new OOPs();
                    }
                }
            }
        });
        jPanel2.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                Point tempPoint = new Point();
                tempPoint.y = Math.round(evt.getX() / 50);
                tempPoint.x = Math.round(evt.getY() / 50);
                int color = control.myArray[lastPoint.x][lastPoint.y].getColor();                
                try{
                if((Math.abs(tempPoint.x - lastPoint.x) > 1 ||Math.abs(tempPoint.y - lastPoint.y) > 1) ){                    
                    throw new Exception();                    
                }
                try {
                    if (!(control.myArray[lastPoint.x][lastPoint.y] instanceof Hull)) {
                        control.myArray[tempPoint.x][tempPoint.y].calledWithDrag(firstPoint, lastPoint, control);
                        if (control.myArray[tempPoint.x][tempPoint.y] instanceof Node) {
                            int mycolor = control.myArray[tempPoint.x][tempPoint.y].getColor();

                            if ((xx[mycolor] > 0) && (myColorPressed == mycolor)) {
                                xx[mycolor] = -xx[mycolor];
                            }
                        }

                    }
                } catch (Exception ArrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(null, "keep your cursor inside the grid while dragging ");
                }
                repaint();
                }catch(Exception e){
                }
            }
        });

        jPanel1.add(jPanel2, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

//    <editor-fold defaultstate = "collapsed" desc  = "temp method">
    //    private void jPanel2MouseDragged(MouseEvent evt) {
    //        }
    //    private void jPanel2MousePressed(MouseEvent evt) {
    //    }
    //    //mouse released//
    //    private void jPanel2MouseReleased(MouseEvent evt) {
    //        }
    // </editor-fold>
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyGame().setVisible(true);
            }
        });
    }

    class Panel2 extends JPanel {

        Panel2() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(20, 20));
        }

        void selectColor(int color, Graphics g) {
            switch (color) {
                case 1:
                    g.setColor(Color.red);
                    break;
                case 2:
                    g.setColor(Color.green);
                    break;
                case 3:
                    g.setColor(Color.blue);
                    break;
                case 4:
                    g.setColor(Color.yellow);
                    break;
                case 5:
                    g.setColor(Color.magenta);
                    break;
                case 6:
                    g.setColor(Color.pink);
                    break;
                case 7:
                    g.setColor(Color.cyan);
                    break;
                case 8:
                    g.setColor(Color.lightGray);
                    break;
                default:
                    g.setColor(Color.black);

                    break;
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i <= control.stage + 4; i++) {
                g.drawLine(i * k, 0, i * k, k * (control.stage + 4));
                g.drawLine(0, i * k, k * (control.stage + 4), i * k);
            }
            Graphics2D g2d = (Graphics2D) g;

            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            boolean first = true;
            g2d.setStroke(new BasicStroke(12));
            for (int i = 0; i < control.arraysOfPaths.size(); i++) {
                for (int j = 0; j < control.arraysOfPaths.get(i).size(); j++) {
                    if (first) {
                        y1 = control.arraysOfPaths.get(i).get(j).getX() * k + 25;
                        x1 = control.arraysOfPaths.get(i).get(j).getY() * k + 25;
                        first = false;
                    } else {
                        if (control.arraysOfPaths.get(i).get(j) instanceof Bridge && control.arraysOfPaths.get(i).get(j).getColor() == i) {
                            if (control.arraysOfPaths.get(i).get(j - 1).getX() < control.arraysOfPaths.get(i).get(j).getX()) {
                                y2 = control.arraysOfPaths.get(i).get(j).getX() * k + 10;
                                x2 = control.arraysOfPaths.get(i).get(j).getY() * k + 25;
                                g2d.drawLine(x1, y1, x2, y2);
                                x1 = x2;
                                y1 = y2 + 30;
                            } else {
                                y2 = control.arraysOfPaths.get(i).get(j).getX() * k + 40;
                                x2 = control.arraysOfPaths.get(i).get(j).getY() * k + 25;
                                g2d.drawLine(x1, y1, x2, y2);
                                x1 = x2;
                                y1 = y2 - 30;
                            }
                        } else {
                            y2 = control.arraysOfPaths.get(i).get(j).getX() * k + 25;
                            x2 = control.arraysOfPaths.get(i).get(j).getY() * k + 25;
                            selectColor(i, g);
                            g2d.drawLine(x1, y1, x2, y2);
                            x1 = x2;
                            y1 = y2;
                        }
                    }
                }
                first = true;
            }
            for (int i = 0; i < control.myArray.length; i++) {
                for (int j = 0; j < control.myArray.length; j++) {
                    if (control.myArray[i][j] instanceof Node) {
                        int myColor = control.myArray[i][j].getColor();

                        selectColor(myColor, g);
//                        Ellipse2D.Double circle = new Ellipse2D.Double((j * k) + 10, (i * k) + 10, 30, 30);
//                        g2d.fill(circle);
                        if (!selevesterUsed[myColor]) {
                            isSelvester = true;
                            if (xx[myColor] > 0) {
                                g.drawImage(Selvester2[myColor], (j * k) + 5, (i * k), this);
                            } else {
                                g.drawImage(Selvester1[myColor], (j * k) + 5, (i * k), this);
                            }
                            selevesterUsed[myColor] = true;
                        } else {
                            if (xx[myColor] > 0) {
                                g.drawImage(Tweety1[myColor], (j * k), (i * k), this);
                            } else {
                                g.drawImage(Tweety2[myColor], (j * k), (i * k), this);
                            }
                            selevesterUsed[myColor] = false;
                        }
                    } else if (control.myArray[i][j] instanceof Hull) {
                        //selectColor(-1, g);
                        //g2d.setStroke(new BasicStroke(12));
                        //g2d.drawString("HULL", (j * k) + 10, (i * k) + 30);

                        g.drawImage(Hull, (j * k) + 0, (i * k) + 0, this);
                    } else if (control.myArray[i][j] instanceof Bridge) {
                        selectColor(-1, g);
                        g2d.setStroke(new BasicStroke(2));
                        g2d.drawLine(control.myArray[i][j].getY() * k, control.myArray[i][j].getX() * k + 16, (control.myArray[i][j].getY() + 1) * k, control.myArray[i][j].getX() * k + 16);
                        g2d.drawLine(control.myArray[i][j].getY() * k, control.myArray[i][j].getX() * k + 34, (control.myArray[i][j].getY() + 1) * k, control.myArray[i][j].getX() * k + 34);

                    }
                }
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
