package GUI.Log_Reg;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dao.PlayerDAO;
import entity.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ForgotPassword extends javax.swing.JFrame {

    private int mouseX, mouseY;

    private static Player player;
    private Timer timer;
    private int remainingTime = 60;
    public ForgotPassword(Player player) {
        initComponents();
        Load();
        CountdownTimer();
    }

    void Load() {
        makePanelDraggable(jPanel1);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 6, 6));

        // Tạo hiệu ứng shadow cho form
        LineBorder lineBorder = new LineBorder(Color.GRAY, 1, true);
        EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);
        CompoundBorder compoundBorder = new CompoundBorder(lineBorder, emptyBorder);
        jPanel1.setBorder(compoundBorder);
    }

    private void makePanelDraggable(javax.swing.JPanel panel) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                int x = evt.getXOnScreen() - mouseX;
                int y = evt.getYOnScreen() - mouseY;

                setLocation(x, y);
            }
        });

    }
    
    private  void CountdownTimer() {
            timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                if (remainingTime >= 0) {
                    updateLabel();
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Time's up!");
                    dispose(); // Đóng cửa sổ khi thời gian kết thúc
                }
            }
        });
            timer.start();
    }
        
        
    private void updateLabel() {
        txt_time.setText( remainingTime + "s");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb_Pass0 = new javax.swing.JLabel();
        btn_reg = new javax.swing.JButton();
        txt_time = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        txt_Email = new javax.swing.JPasswordField();
        lb_Pass1 = new javax.swing.JLabel();
        txt_Password1 = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Close_Form = new javax.swing.JButton();
        lb_Email = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 143, 255, 10));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Sent.png"))); // NOI18N
        jLabel8.setToolTipText("Gửi mã xác minh");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lấy Lại Mật Khẩu");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 18, -1, -1));

        lb_Pass0.setForeground(new java.awt.Color(255, 255, 255));
        lb_Pass0.setText("Mật Khẩu");
        jPanel1.add(lb_Pass0, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 79, -1, -1));

        btn_reg.setBackground(new java.awt.Color(0, 0, 0));
        btn_reg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_reg.setForeground(new java.awt.Color(255, 255, 255));
        btn_reg.setText("Xác Minh");
        btn_reg.setBorderPainted(false);
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 321, 50));
        btn_reg.setBorderPainted(false);
        btn_reg.setFocusPainted(false);

        txt_time.setText("60s");
        jPanel1.add(txt_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        txt_Password.setBackground(new java.awt.Color(153, 153, 255));
        txt_Password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Password.setBorder(null);
        jPanel1.add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 101, 248, 36));

        txt_Email.setBackground(new java.awt.Color(153, 153, 255));
        txt_Email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Email.setBorder(null);
        txt_Email.setEchoChar((char) 0);
        jPanel1.add(txt_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 303, 255, 32));

        lb_Pass1.setForeground(new java.awt.Color(255, 255, 255));
        lb_Pass1.setText("Nhập Lại Mật Khẩu");
        jPanel1.add(lb_Pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 177, -1, -1));

        txt_Password1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Password1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Password1.setBorder(null);
        jPanel1.add(txt_Password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 199, 248, 36));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 241, 255, 10));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Password.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 105, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Password.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 199, -1, -1));

        Close_Form.setBackground(new java.awt.Color(153, 153, 255));
        Close_Form.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Close.png"))); // NOI18N
        Close_Form.setBorder(null);
        Close_Form.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Close_Form.setMaximumSize(new java.awt.Dimension(35, 35));
        Close_Form.setMinimumSize(new java.awt.Dimension(35, 35));
        Close_Form.setPreferredSize(new java.awt.Dimension(35, 35));
        Close_Form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close_FormActionPerformed(evt);
            }
        });
        jPanel1.add(Close_Form, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 33, 33));

        lb_Email.setForeground(new java.awt.Color(255, 255, 255));
        lb_Email.setText("Email");
        jPanel1.add(lb_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 277, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 341, 255, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed

        PlayerDAO pdao = new PlayerDAO();
        List<Player> playerList = pdao.getAllPlayers();
        StringBuilder sb = new StringBuilder();
        String password = txt_Password.getText();
        String password2 = txt_Password1.getText();
        String email = txt_Email.getText();
        
        boolean isCheck = false;
        
        if(password.equals("") || password2.equals("") || email.equals("") ) {
            sb.append("Khong duoc bo trong");
        }else if(password.equals("") && password2.equals("") && email.equals("") ) {
            sb.append("Khong duoc bo trong");
        }else {
            for(Player p : playerList) {
                if(!p.getEmail().equals(email)) {
                    sb.append("Email khong ton tai");
                    break;
                }else {
                    isCheck = true;
                }
            }
        }
        
        if(isCheck) {
            player.setPassword(password);
            pdao.updatePasswordOfPlayer(player);
            sb.append("Đổi mật khẩu thành công!");
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
            
        }
        
        
        // Kiểm tra thong tin nhập vào đã đầy đủ sẽ cueyrn form
        JPasswordField[] passwordFields = {txt_Password, txt_Password1, txt_Email};
        JLabel[] labels = {lb_Pass0, lb_Pass1, lb_Email};

        boolean hasEmptyField = false;

        for (int i = 0; i < passwordFields.length; i++) {
            if (passwordFields[i].getPassword().length == 0) {
                labels[i].setForeground(Color.RED);
                hasEmptyField = true;
            } else {
                labels[i].setForeground(Color.WHITE);
            }
        }

        if (!hasEmptyField) {
            this.setVisible(false);
            Login Log = new Login();
            Log.setVisible(true);
        }
    }//GEN-LAST:event_btn_regActionPerformed

    private void Close_FormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close_FormActionPerformed
        dispose();// Đóng form
    }//GEN-LAST:event_Close_FormActionPerformed

    public static void main(String args[]) {

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword(player).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close_Form;
    private javax.swing.JButton btn_reg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lb_Email;
    private javax.swing.JLabel lb_Pass0;
    private javax.swing.JLabel lb_Pass1;
    private javax.swing.JPasswordField txt_Email;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JPasswordField txt_Password1;
    private javax.swing.JLabel txt_time;
    // End of variables declaration//GEN-END:variables
}
