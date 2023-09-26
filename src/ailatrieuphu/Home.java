package ailatrieuphu;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import jaco.mp3.player.MP3Player;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.net.URL;
import javax.swing.UIManager;

public class Home extends javax.swing.JFrame {

    private int mouseX, mouseY;
    
    // GET FILE MP3
    ClassLoader classLoader = getClass().getClassLoader();
    URL resourceURL = classLoader.getResource("Audio/batdau.mp3");
    File mp3File = new File(resourceURL.getFile());
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
        btn_LogOut = new javax.swing.JButton();
        btn_Play = new javax.swing.JButton();
        btn_EXIT = new javax.swing.JButton();
        btn_OnMute = new javax.swing.JLabel();
        btn_OFFmute = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1600, 900));
        setMinimumSize(new java.awt.Dimension(1600, 900));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_User.setBackground(new java.awt.Color(0, 0, 0));
        lb_User.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb_User.setForeground(new java.awt.Color(255, 255, 255));
        lb_User.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_User.setText("Người chơi:  Trần Hoàng Anh");
        lb_User.setAlignmentX(0.5F);
        getContentPane().add(lb_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 490, 40));
        lb_User.setOpaque(false);

        btn_LogOut.setBackground(new java.awt.Color(153, 153, 255));
        btn_LogOut.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btn_LogOut.setForeground(new java.awt.Color(255, 255, 255));
        btn_LogOut.setText("Đăng Xuất");
        btn_LogOut.setToolTipText("");
        btn_LogOut.setPreferredSize(new java.awt.Dimension(98, 55));
        btn_LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogOutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 750, 290, 70));
        btn_Play.setBorderPainted(false);
        btn_Play.setFocusPainted(false);

        btn_Play.setBackground(new java.awt.Color(102, 255, 102));
        btn_Play.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btn_Play.setText("Play");
        btn_Play.setPreferredSize(new java.awt.Dimension(98, 55));
        btn_Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PlayActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 680, 280, 70));
        btn_Play.setBorderPainted(false);
        btn_Play.setFocusPainted(false);

        btn_EXIT.setBackground(new java.awt.Color(255, 102, 102));
        btn_EXIT.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btn_EXIT.setForeground(new java.awt.Color(255, 255, 255));
        btn_EXIT.setText("EXIT");
        btn_EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EXITActionPerformed(evt);
            }
        });
        getContentPane().add(btn_EXIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 750, 200, 70));
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Trần Huy Hoàng");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 252, 190, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("1");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("2");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 315, -1, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nguyễn Văn Tuyền");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 318, 190, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Vũ Trọng Phụng");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 190, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("3");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Bùi Đức Duy");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 190, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("4");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, -1, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Lê Văn Luyện");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 190, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("5");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, -1, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("1");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 240, -1, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ngô Hoàng Anh");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 240, 190, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Trịnh Thị Trang");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 308, 190, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("2");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 310, -1, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("3");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 380, -1, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Mai Văn Táng");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 379, 190, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Trần Thùy Trang");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 440, 190, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("4");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 440, -1, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("5");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 500, -1, 50));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Ngô Bá Khá");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 500, 190, 50));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ranks.png"))); // NOI18N
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 240, 360, 330));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LGO.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 200, 210));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ranks.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 360, 330));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg_TopWeek.png"))); // NOI18N
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 440, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg_RanksMonth.png"))); // NOI18N
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 440, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg_startGame.png"))); // NOI18N
        BG.setRequestFocusEnabled(false);
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        setSize(new java.awt.Dimension(1595, 900));
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
        setVisible(false);
        Dashboard Das = new Dashboard();
        Das.setVisible(true);
    }//GEN-LAST:event_btn_PlayActionPerformed

    private void btn_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogOutActionPerformed
        setVisible(false);
        Login loggin = new Login();
        loggin.setVisible(true);
    }//GEN-LAST:event_btn_LogOutActionPerformed

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

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btn_EXIT;
    private javax.swing.JButton btn_LogOut;
    private javax.swing.JLabel btn_OFFmute;
    private javax.swing.JLabel btn_OnMute;
    private javax.swing.JButton btn_Play;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_User;
    // End of variables declaration//GEN-END:variables
}
