package ailatrieuphu;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Login extends javax.swing.JFrame {

    private int mouseX, mouseY;
    private boolean PassShow = false;

    public Login() {

        setUndecorated(true);
        initComponents();
        LOAD();
    }

    void LOAD() {
        makePanelDraggable(jPanel1);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 4, 4));

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_Acc = new javax.swing.JLabel();
        lb_Pass = new javax.swing.JLabel();
        btn_Login = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_HidePass = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        btn_Reg = new javax.swing.JLabel();
        chx_save = new javax.swing.JCheckBox();
        txt_UserName = new javax.swing.JPasswordField();
        Close_Form = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Chào bạn . Chúng ta cùng bắt đầu nào");

        lb_Acc.setForeground(new java.awt.Color(255, 255, 255));
        lb_Acc.setText("Tài khoản");

        lb_Pass.setForeground(new java.awt.Color(255, 255, 255));
        lb_Pass.setText("Mật Khẩu");

        btn_Login.setBackground(new java.awt.Color(0, 0, 0));
        btn_Login.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Login.setForeground(new java.awt.Color(255, 255, 255));
        btn_Login.setText("Đăng Nhập");
        btn_Login.setBorderPainted(false);
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Male User.png"))); // NOI18N

        btn_HidePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UnHide.png"))); // NOI18N
        btn_HidePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_HidePassMouseClicked(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Chưa có tài khoản?");

        txt_Password.setBackground(new java.awt.Color(153, 153, 255));
        txt_Password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Password.setBorder(null);
        txt_Password.setSelectionColor(new java.awt.Color(0, 153, 255));

        btn_Reg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Reg.setForeground(new java.awt.Color(255, 255, 255));
        btn_Reg.setText("Đăng Kí");
        btn_Reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_RegMouseClicked(evt);
            }
        });

        chx_save.setBackground(new java.awt.Color(153, 153, 255));
        chx_save.setForeground(new java.awt.Color(255, 255, 255));
        chx_save.setText("Lưu cho lần sau");
        chx_save.setBorder(null);
        chx_save.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chx_save.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        txt_UserName.setBackground(new java.awt.Color(153, 153, 255));
        txt_UserName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_UserName.setBorder(null);
        txt_UserName.setEchoChar((char) 0);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Close_Form, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(35, 35, 35)
                .addComponent(btn_Reg)
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chx_save))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_Pass)
                                    .addComponent(lb_Acc))
                                .addGap(210, 210, 210)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_HidePass, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Close_Form, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(65, 65, 65)
                .addComponent(lb_Acc)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addComponent(lb_Pass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_HidePass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chx_save)
                .addGap(30, 30, 30)
                .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btn_Reg))
                .addGap(21, 21, 21))
        );

        btn_Login.setBorderPainted(false);
        btn_Login.setFocusPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed

        // Kiểm tra thong tin nhập vào đã đầy đủ sẽ cueyrn form
        JPasswordField[] passwordFields = {txt_UserName, txt_Password};
        JLabel[] labels = {lb_Acc, lb_Pass};

        boolean hasEmptyField = false;

        for (int i = 0; i < passwordFields.length; i++) {
            if (passwordFields[i].getPassword().length == 0) {
                labels[i].setForeground(Color.RED);
                hasEmptyField = true;
            } else {
                labels[i].setForeground(Color.WHITE);
            }
        }

        if (new String(txt_UserName.getPassword()).equals("admin") && !hasEmptyField) {
            this.setVisible(false);
            Admin_System admin = new Admin_System();
            admin.setVisible(true);
        } else {
            if (!hasEmptyField) {

                this.setVisible(false);
                Home home = new Home();
                home.setVisible(true);
            }
        }


    }//GEN-LAST:event_btn_LoginActionPerformed

    private void Close_FormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close_FormActionPerformed
        dispose();// Đóng form
    }//GEN-LAST:event_Close_FormActionPerformed

    private void btn_RegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RegMouseClicked
        setVisible(false);
        Register Reg = new Register();
        Reg.setVisible(true);
    }//GEN-LAST:event_btn_RegMouseClicked

    private void btn_HidePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HidePassMouseClicked
        Icon Hide = new ImageIcon(getClass().getClassLoader().getResource("img/Hide.png"));
        Icon UnHide = new ImageIcon(getClass().getClassLoader().getResource("img/UnHide.png"));
        if (!PassShow) {
            // Hiện Pass 
            txt_Password.setEchoChar((char)0);
            btn_HidePass.setIcon(UnHide);
            PassShow = true;
        } else {
            // ẩn pass
            txt_Password.setEchoChar('\u2022');
            btn_HidePass.setIcon(Hide);
            PassShow = false;

        }


    }//GEN-LAST:event_btn_HidePassMouseClicked

    public static void main(String args[]) {

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close_Form;
    private javax.swing.JLabel btn_HidePass;
    private javax.swing.JButton btn_Login;
    private javax.swing.JLabel btn_Reg;
    private javax.swing.JCheckBox chx_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb_Acc;
    private javax.swing.JLabel lb_Pass;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JPasswordField txt_UserName;
    // End of variables declaration//GEN-END:variables

    void Visible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
