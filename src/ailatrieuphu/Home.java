/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ailatrieuphu;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.AbstractBorder;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

public class Home extends javax.swing.JFrame {

    private int mouseX, mouseY;
    File mp3File = new File("F:/JAVA/AiLaTrieuPhu/src/Audio/batdau.mp3");
    MP3Player mp3Player = new MP3Player(mp3File);

    public Home() {
        setUndecorated(true);
        initComponents();
        Load();
    }

    void Load() {
        makeLabelDraggable(BG);

        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 12, 12));

        btn_OFFmute.setVisible(false);
        btn_OnMute.setVisible(true);

        mp3Player.play();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_User = new javax.swing.JLabel();
        btn_Play = new javax.swing.JButton();
        btn_EXIT = new javax.swing.JButton();
        btn_OnMute = new javax.swing.JLabel();
        btn_OFFmute = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_User.setBackground(new java.awt.Color(0, 0, 0));
        lb_User.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_User.setForeground(new java.awt.Color(255, 255, 255));
        lb_User.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_User.setText("Người chơi:  Trần Hoàng Anh");
        lb_User.setAlignmentX(0.5F);
        lb_User.setOpaque(true);
        getContentPane().add(lb_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 290, 40));
        lb_User.setOpaque(true);

        btn_Play.setBackground(new java.awt.Color(0, 0, 0));
        btn_Play.setForeground(new java.awt.Color(255, 255, 255));
        btn_Play.setText("Play");
        btn_Play.setBorder(null);
        btn_Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PlayActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 110, 40));
        btn_Play.setBorderPainted(false);
        btn_Play.setFocusPainted(false);

        btn_EXIT.setBackground(new java.awt.Color(0, 0, 0));
        btn_EXIT.setForeground(new java.awt.Color(255, 255, 255));
        btn_EXIT.setText("EXIT");
        btn_EXIT.setBorder(null);
        btn_EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EXITActionPerformed(evt);
            }
        });
        getContentPane().add(btn_EXIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 110, 40));
        btn_EXIT.setBorderPainted(false);
        btn_EXIT.setFocusPainted(false);

        btn_OnMute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Speaker.png"))); // NOI18N
        btn_OnMute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_OnMuteMouseClicked(evt);
            }
        });
        getContentPane().add(btn_OnMute, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        btn_OnMute.setVisible(false);

        btn_OFFmute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/No Audio_1.png"))); // NOI18N
        btn_OFFmute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_OFFmuteMouseClicked(evt);
            }
        });
        getContentPane().add(btn_OFFmute, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/jpg.jpg"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        setSize(new java.awt.Dimension(599, 400));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btn_EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EXITActionPerformed
        dispose();// Đóng form
    }//GEN-LAST:event_btn_EXITActionPerformed

    private void btn_OnMuteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_OnMuteMouseClicked
        btn_OFFmute.setVisible(true);
        btn_OnMute.setVisible(false);
        mp3Player.stop();
    }//GEN-LAST:event_btn_OnMuteMouseClicked

    private void btn_OFFmuteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_OFFmuteMouseClicked
        btn_OFFmute.setVisible(false);
        btn_OnMute.setVisible(true);
        mp3Player.play();
    }//GEN-LAST:event_btn_OFFmuteMouseClicked

    private void btn_PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PlayActionPerformed

    }//GEN-LAST:event_btn_PlayActionPerformed

    private void makeLabelDraggable(javax.swing.JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                int x = evt.getXOnScreen() - mouseX;
                int y = evt.getYOnScreen() - mouseY;

                setLocation(x, y);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btn_EXIT;
    private javax.swing.JLabel btn_OFFmute;
    private javax.swing.JLabel btn_OnMute;
    private javax.swing.JButton btn_Play;
    private javax.swing.JLabel lb_User;
    // End of variables declaration//GEN-END:variables
}
