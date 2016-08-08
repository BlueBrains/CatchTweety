/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Molham
 */
public class SelectStage extends javax.swing.JFrame {

    public static int NumberOfStage = 0;

    /**
     * Creates new form SelectStage
     */
    public SelectStage() {
        initComponents();
        this.setVisible(true);
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
        Stage1 = new javax.swing.JButton();
        Stage2 = new javax.swing.JButton();
        Srage3 = new javax.swing.JButton();
        Stage4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Select Stage");
        setResizable(false);

        jPanel1.setLayout(null);

        Stage1.setText("Stag1 (5,5)");
        Stage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stage1ActionPerformed(evt);
            }
        });
        jPanel1.add(Stage1);
        Stage1.setBounds(30, 90, 100, 23);

        Stage2.setText("Stag2 (6,6)");
        Stage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stage2ActionPerformed(evt);
            }
        });
        jPanel1.add(Stage2);
        Stage2.setBounds(30, 130, 100, 23);

        Srage3.setText("Stag3 (7,7)");
        Srage3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Srage3ActionPerformed(evt);
            }
        });
        jPanel1.add(Srage3);
        Srage3.setBounds(30, 170, 100, 23);

        Stage4.setText("Stag4 (8,8)");
        Stage4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stage4ActionPerformed(evt);
            }
        });
        jPanel1.add(Stage4);
        Stage4.setBounds(30, 210, 100, 23);

        jLabel1.setFont(new java.awt.Font("Lotus Linotype", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html><font size = 3 color=\"black\" > &nbsp;&nbsp;&nbsp;Select Number Of Stage , Please</font> </html>");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 200, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/images2.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 50, 190, 260);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(322, 345));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Stage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stage1ActionPerformed
        NumberOfStage = 1;        
        SelectLevel level = new SelectLevel();
        this.setVisible(false);
    }//GEN-LAST:event_Stage1ActionPerformed

    private void Stage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stage2ActionPerformed
        NumberOfStage = 2;        
        SelectLevel level = new SelectLevel();
        this.setVisible(false);
    }//GEN-LAST:event_Stage2ActionPerformed

    private void Srage3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Srage3ActionPerformed
        NumberOfStage = 3;        
        SelectLevel level = new SelectLevel();        
        this.setVisible(false);
    }//GEN-LAST:event_Srage3ActionPerformed

    private void Stage4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stage4ActionPerformed
        NumberOfStage = 4;        
        SelectLevel level = new SelectLevel();
        this.setVisible(false);
    }//GEN-LAST:event_Stage4ActionPerformed

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
            java.util.logging.Logger.getLogger(SelectStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectStage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Srage3;
    private javax.swing.JButton Stage1;
    private javax.swing.JButton Stage2;
    private javax.swing.JButton Stage4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
