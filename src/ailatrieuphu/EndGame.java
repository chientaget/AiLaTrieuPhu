package ailatrieuphu;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EndGame extends javax.swing.JFrame {

    private int mouseX, mouseY;

    private static Icon[] icons = {
       // new ImageIcon(EndGame.class.getClassLoader().getResource("img/qua00.png")),
        new ImageIcon(EndGame.class.getClassLoader().getResource("img/qua01.png")),
        new ImageIcon(EndGame.class.getClassLoader().getResource("img/qua02.png")),
        new ImageIcon(EndGame.class.getClassLoader().getResource("img/qua03.png")),
        new ImageIcon(EndGame.class.getClassLoader().getResource("img/qua04.png"))
    };

    public EndGame() {
        initComponents();
        LOAD();
    }

    void LOAD() {

        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 4, 4));
        makeLabelDraggable(jLabel1);
    }

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

    public static void SetIconRandom(JLabel lb) {
        Random rd = new Random();
        int randomIndex = rd.nextInt(icons.length); // Random index between 0 and icons.length-1
        lb.setIcon(icons[randomIndex]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Exit = new javax.swing.JButton();
        btn_ResetGame = new javax.swing.JButton();
        btn_openQua = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 760));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 760));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LGO.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Với giải thưởng 100.000.000 VNĐ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 600, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Chúc Mừng Người : Nguyễn Quyết Thắng ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 710, 50));

        btn_Exit.setBackground(new java.awt.Color(0, 0, 0));
        btn_Exit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_Exit.setForeground(new java.awt.Color(255, 255, 255));
        btn_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout_1.png"))); // NOI18N
        btn_Exit.setText("Thoát Game");
        btn_Exit.setBorderPainted(false);
        btn_Exit.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 650, 250, 60));
        btn_ResetGame.setBorderPainted(false);
        btn_ResetGame.setFocusPainted(false);

        btn_ResetGame.setBackground(new java.awt.Color(0, 0, 0));
        btn_ResetGame.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_ResetGame.setForeground(new java.awt.Color(255, 255, 255));
        btn_ResetGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reset_1.png"))); // NOI18N
        btn_ResetGame.setText("Chơi Lại");
        btn_ResetGame.setBorderPainted(false);
        getContentPane().add(btn_ResetGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, 220, 60));
        btn_ResetGame.setBorderPainted(false);
        btn_ResetGame.setFocusPainted(false);

        btn_openQua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/qua00.png"))); // NOI18N
        btn_openQua.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_openQua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_openQuaMouseClicked(evt);
            }
        });
        getContentPane().add(btn_openQua, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 510, 90, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BG_endGame.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 760));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Lê Văn Luyện");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 190, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("5");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, -1, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("4");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, -1, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Bùi Đức Duy");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 190, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Vũ Trọng Phụng");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 190, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("3");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("2");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 315, -1, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nguyễn Văn Tuyền");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 318, 190, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Trần Huy Hoàng");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 252, 190, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("1");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, 40));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg_TopWeek.png"))); // NOI18N
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 440, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ranks.png"))); // NOI18N
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 360, 330));

        setSize(new java.awt.Dimension(1359, 760));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed
        dispose();// Đóng form
    }//GEN-LAST:event_btn_ExitActionPerformed

    private void btn_openQuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_openQuaMouseClicked

        // mở quà
        SetIconRandom(btn_openQua);
        

    }//GEN-LAST:event_btn_openQuaMouseClicked

    public static void main(String args[]) {

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EndGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Exit;
    private javax.swing.JButton btn_ResetGame;
    private javax.swing.JLabel btn_openQua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
