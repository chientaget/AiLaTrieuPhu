package GUI.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Call extends javax.swing.JFrame {

    Icon bac = new ImageIcon(getClass().getClassLoader().getResource("img/bac.png"));
    Icon chi = new ImageIcon(getClass().getClassLoader().getResource("img/chi.png"));
    Icon anh = new ImageIcon(getClass().getClassLoader().getResource("img/anh.png"));
    private int mouseX, mouseY;
    private Timer timer;
    private int minutes = 0;
    private int seconds = 30;
    public Call() {
        initComponents();
        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 4, 4));
        makeLabelDraggable(jLabel1);
        CountdownTimer();
    }
    
    
   
        private  void CountdownTimer() {
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateTimerLabel();
                }
            });

            timer.setInitialDelay(0);
            timer.start();
        }
        
        
    private void updateTimerLabel() {
        if (minutes == 0 && seconds == 0) {
            timer.stop();
            this.setVisible(false);
        } else {
            if (seconds == 0) {
                minutes--;
                seconds = 59;
            } else {
                seconds--;
            }

            String time = String.format("%02d:%02d", minutes, seconds);
            time_lb.setText(time);
        }
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

    void ShowDapAn() {
        // Đặt đáp án sau 3 giây
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> ans = new ArrayList<>();
                ans.add("A");
                ans.add("B");
                ans.add("C");
                ans.add("D");
                Collections.shuffle(ans);
                // Hiển thị đáp án sau 3 giây
                img_call.setIcon(null);
                img_call.setText(ans.get(1));
            }
        });

        timer.setRepeats(false); // Không lặp lại timer sau khi chạy xong
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_Bac = new javax.swing.JButton();
        btn_Chi = new javax.swing.JButton();
        btn_Anh = new javax.swing.JButton();
        time_lb = new javax.swing.JLabel();
        img_call = new javax.swing.JLabel();
        Close_Form = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 226, 204));

        jPanel2.setBackground(new java.awt.Color(255, 226, 204));

        btn_Bac.setBackground(new java.awt.Color(153, 153, 255));
        btn_Bac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_Bac.setForeground(new java.awt.Color(255, 255, 255));
        btn_Bac.setText("Bác Sáng");
        btn_Bac.setBorderPainted(false);
        btn_Bac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BacActionPerformed(evt);
            }
        });

        btn_Chi.setBackground(new java.awt.Color(153, 153, 255));
        btn_Chi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_Chi.setForeground(new java.awt.Color(255, 255, 255));
        btn_Chi.setText("Chị SU");
        btn_Chi.setBorderPainted(false);
        btn_Chi.setFocusPainted(false);
        btn_Chi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChiActionPerformed(evt);
            }
        });

        btn_Anh.setBackground(new java.awt.Color(153, 153, 255));
        btn_Anh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_Anh.setForeground(new java.awt.Color(255, 255, 255));
        btn_Anh.setText("Anh Quang");
        btn_Anh.setBorderPainted(false);
        btn_Anh.setFocusPainted(false);
        btn_Anh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnhActionPerformed(evt);
            }
        });

        time_lb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        time_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time_lb.setText("00:30");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Anh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Bac, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Chi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(time_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(time_lb)
                .addGap(18, 18, 18)
                .addComponent(btn_Bac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Chi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Anh)
                .addGap(15, 15, 15))
        );

        btn_Bac.setBorderPainted(false);
        btn_Bac.setFocusPainted(false);
        btn_Bac.setBorderPainted(false);
        btn_Bac.setFocusPainted(false);
        btn_Bac.setBorderPainted(false);
        btn_Bac.setFocusPainted(false);

        img_call.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        img_call.setForeground(new java.awt.Color(51, 204, 0));
        img_call.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img_call.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bac.png"))); // NOI18N
        img_call.setEnabled(false);
        img_call.setInheritsPopupMenu(false);

        Close_Form.setBackground(new java.awt.Color(255, 226, 204));
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
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(img_call, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Close_Form, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(img_call, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Close_Form, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 440));

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BacActionPerformed
        img_call.setIcon(bac);
        btn_Anh.setEnabled(false);
        btn_Chi.setEnabled(false);
        img_call.enable(true);
         ShowDapAn();
    }//GEN-LAST:event_btn_BacActionPerformed

    private void btn_AnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnhActionPerformed
        btn_Bac.setEnabled(false);
        btn_Chi.setEnabled(false);
        img_call.setIcon(anh);
        img_call.enable(true);
        ShowDapAn();
    }//GEN-LAST:event_btn_AnhActionPerformed

    private void btn_ChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChiActionPerformed
        btn_Anh.setEnabled(false);
        btn_Bac.setEnabled(false);
        img_call.setIcon(chi);
        img_call.enable(true);
        ShowDapAn();
    }//GEN-LAST:event_btn_ChiActionPerformed

    private void Close_FormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close_FormActionPerformed
        dispose();// Đóng form
    }//GEN-LAST:event_Close_FormActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Call().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close_Form;
    private javax.swing.JButton btn_Anh;
    private javax.swing.JButton btn_Bac;
    private javax.swing.JButton btn_Chi;
    private javax.swing.JLabel img_call;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel time_lb;
    // End of variables declaration//GEN-END:variables
}
