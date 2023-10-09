package GUI.Admin;

import GUI.Log_Reg.Login;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dao.PlayerDAO;
import dao.QuestionDAO;
import entity.Admin;
import entity.Player;
import entity.Question;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Admin_System extends javax.swing.JFrame {

    private int mouseX, mouseY;
    private boolean isFullScreen = false;

    private static Admin admin;

    public Admin_System(Admin admin) {
        this.admin = admin;
        setUndecorated(true);
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        LOAD();

    }

    void LOAD() {

        getAllUser();
        getAllQuestion();
        makePanelDraggable(PL_heard);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 4, 4));

        // Tạo hiệu ứng shadow cho form
        LineBorder lineBorder = new LineBorder(Color.GRAY, 1, true);
        EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);
        CompoundBorder compoundBorder = new CompoundBorder(lineBorder, emptyBorder);
        PL_heard.setBorder(compoundBorder);

        applyTableStyle(Tb_User);
        Tb_User.setSelectionBackground(new Color(102, 102, 255));
        Tb_CauHoi.setSelectionBackground(new Color(102, 102, 255));
        Tb_CauHoi.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private void getAllUser() {
        removealldata(Tb_User);
        PlayerDAO pdao = new PlayerDAO();
        List<Player> playerList = pdao.getAllPlayers();

        DefaultTableModel model = (DefaultTableModel) Tb_User.getModel();
        for (Player p : playerList) {
            model.addRow(new Object[]{
                false,
                p.getId(),
                p.getFullName(),
                p.getUsername(),
                p.getPassword(),
                p.getEmail(),
                p.getTotalMoney()
            });
        }
        Tb_User.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private void deleteUser(int ID) {
        PlayerDAO pdao = new PlayerDAO();
        pdao.deletePlayer(ID);
    }

    private void deleteQues(int ID) {
        QuestionDAO pdao = new QuestionDAO();
        pdao.deleteQuestion(ID);
    }

    private static void removealldata(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void getAllQuestion() {
        removealldata(Tb_CauHoi);
        QuestionDAO qdao = new QuestionDAO();
        List<Question> quesList = qdao.getAllQuestions();

        DefaultTableModel model = (DefaultTableModel) Tb_CauHoi.getModel();
        for (Question q : quesList) {
            model.addRow(new Object[]{
                false,
                q.getId(),
                q.getQues(),
                q.getAnswerCorrect(),
                q.getAnswer1(),
                q.getAnswer2(),
                q.getAnswer3()

            });
        }
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

    // random user name , pass , tiền thưởng
    private Object[] getRandomRow(String name) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        Random ran = new Random();

        int id = ran.nextInt(1000, 9999);
        // Generate random username and password
        String username = generateRandomString(8);  // Change 8 to the desired length
        String password = generateRandomString(12); // Change 12 to the desired length

        // Generate random earnings
        double earnings = (ran.nextInt(9999999 - 9999) + 9999) * ran.nextDouble();
        String formattedEarnings = "$" + df.format(0).replace(",", ".");

        return new Object[]{false, id, name, username, password, formattedEarnings};
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    // chèn icon button
    private void applyTableStyle(JTable table) {

        cmdAdd.setIcon(new FlatSVGIcon("tableview/icon/add.svg", 0.35f));
        cmdUpdate.setIcon(new FlatSVGIcon("tableview/icon/edit.svg", 0.35f));
        cmdDelete.setIcon(new FlatSVGIcon("tableview/icon/delete.svg", 0.35f));
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, new FlatSVGIcon("tableview/icon/search.svg", 0.35f));
        //  Change scroll style
        JScrollPane scroll = (JScrollPane) table.getParent().getParent();
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Table.background;"
                + "track:$Table.background;"
                + "trackArc:999");

        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        table.putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");

    }

    // Create a Random instance
    Random random = new Random();
    DecimalFormat decimalFormat = new DecimalFormat("###,###,### VNĐ");

    private TableCellRenderer getAlignmentCellRender(TableCellRenderer oldRender, boolean header) {
        return new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component com = oldRender.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (com instanceof JLabel) {
                    JLabel label = (JLabel) com;
                    if (column == 0 || column == 4) {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                    } else if (column == 2 || column == 3) {
                        label.setHorizontalAlignment(SwingConstants.TRAILING);
                    } else {
                        label.setHorizontalAlignment(SwingConstants.LEADING);
                    }
                    if (header == false) {
                        if (column == 4) {
                            // Generate a random earnings value between 100,000 and 150,000,000
                            double earnings = 100000 + (random.nextDouble() * (150000000 - 100000));
                            // Format the earnings to display with periods and the "VNĐ" symbol
                            String formattedEarnings = decimalFormat.format(earnings);

                            if (earnings > 0) {
                                com.setForeground(new Color(17, 182, 60));
                                label.setText("+" + formattedEarnings);
                            } else {
                                com.setForeground(new Color(202, 48, 48));
                                label.setText(formattedEarnings);
                            }
                        } else {
                            if (isSelected) {
                                com.setForeground(table.getSelectionForeground());
                            } else {
                                com.setForeground(table.getForeground());
                            }
                        }
                    }
                }
                return com;
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PL_heard = new javax.swing.JPanel();
        btn_LogOut = new javax.swing.JLabel();
        btn_mode = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Ques = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        txt_AnsCr = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txt_Ans1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txt_Ans2 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txt_Ans3 = new javax.swing.JTextField();
        btn_Add = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_Topic = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        crazyPanel5 = new raven.crazypanel.CrazyPanel();
        crazyPanel6 = new raven.crazypanel.CrazyPanel();
        txtSearch2 = new javax.swing.JTextField();
        cmdLoad1 = new javax.swing.JButton();
        cmdDelete2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tb_CauHoi = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        crazyPanel4 = new raven.crazypanel.CrazyPanel();
        crazyPanel3 = new raven.crazypanel.CrazyPanel();
        txtSearch = new javax.swing.JTextField();
        cmdLoad = new javax.swing.JButton();
        cmdAdd = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tb_User = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PL_heard.setBackground(new java.awt.Color(51, 51, 51));
        PL_heard.setAlignmentX(0.0F);
        PL_heard.setAlignmentY(0.0F);

        btn_LogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout Rounded.png"))); // NOI18N
        btn_LogOut.setToolTipText("Đăng Xuất");
        btn_LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LogOutMouseClicked(evt);
            }
        });

        btn_mode.setText("Light");
        btn_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ADMIN");

        javax.swing.GroupLayout PL_heardLayout = new javax.swing.GroupLayout(PL_heard);
        PL_heard.setLayout(PL_heardLayout);
        PL_heardLayout.setHorizontalGroup(
            PL_heardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PL_heardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btn_mode)
                .addGap(205, 205, 205)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_LogOut)
                .addGap(19, 19, 19))
        );
        PL_heardLayout.setVerticalGroup(
            PL_heardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PL_heardLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(PL_heardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_LogOut)
                    .addGroup(PL_heardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_mode)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setAlignmentX(0.0F);
        jTabbedPane1.setAlignmentY(0.0F);
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });
        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane1KeyPressed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("ID");

        jLabel2.setText("Câu Hỏi:");

        txt_Ques.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_Ques.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(txt_Ques);

        jLabel4.setText("Đáp án đúng");

        txt_AnsCr.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_AnsCr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_AnsCr.setEchoChar((char) 0);

        jLabel5.setText("Đáp án 2");

        txt_Ans1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Ans1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_Ans1.setEchoChar((char) 0);

        jLabel6.setText("Đáp án 3");

        txt_Ans2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Ans2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_Ans2.setEchoChar((char) 0);

        jLabel7.setText("Đáp án 4");

        txt_Ans3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Ans3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_Add.setBackground(new java.awt.Color(0, 0, 0));
        btn_Add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Add.setForeground(new java.awt.Color(255, 255, 255));
        btn_Add.setText("Thêm");
        btn_Add.setBorderPainted(false);
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        jTextField1.setText("ID tự động tăng");
        jTextField1.setFocusable(false);

        jLabel9.setText("Topic:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_AnsCr)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ans1)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ans2)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ans3)
                            .addComponent(btn_Add, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(328, 328, 328)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(92, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Topic, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Topic, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txt_AnsCr, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txt_Ans1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txt_Ans2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txt_Ans3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        btn_Add.setBorderPainted(false);
        btn_Add.setFocusPainted(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thêm Câu Hỏi", jPanel5);

        crazyPanel5.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background;[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20",
            null
        ));
        crazyPanel5.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fill,insets 15",
            "[fill]",
            "[grow 0][fill]",
            null
        ));

        crazyPanel6.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background",
            new String[]{
                "JTextField.placeholderText=Search;background:@background",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1"
            }
        ));
        crazyPanel6.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "",
            "[]push[][]",
            "",
            new String[]{
                "width 200"
            }
        ));
        crazyPanel6.add(txtSearch2);

        cmdLoad1.setText("Load");
        cmdLoad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoad1ActionPerformed(evt);
            }
        });
        crazyPanel6.add(cmdLoad1);

        cmdDelete2.setText("Delete");
        cmdDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDelete2ActionPerformed(evt);
            }
        });
        crazyPanel6.add(cmdDelete2);

        crazyPanel5.add(crazyPanel6);

        Tb_CauHoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Câu hỏi", "Đáp án Đúng", "Đáp án 2", "Đáp án 3", "Đáp án 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tb_CauHoi.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane4.setViewportView(Tb_CauHoi);
        if (Tb_CauHoi.getColumnModel().getColumnCount() > 0) {
            Tb_CauHoi.getColumnModel().getColumn(0).setPreferredWidth(15);
            Tb_CauHoi.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        crazyPanel5.add(jScrollPane4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crazyPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crazyPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ngân Hàng Câu Hỏi", jPanel2);

        crazyPanel4.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background;[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20",
            null
        ));
        crazyPanel4.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fill,insets 15",
            "[fill]",
            "[grow 0][fill]",
            null
        ));

        crazyPanel3.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background",
            new String[]{
                "JTextField.placeholderText=Search;background:@background",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1"
            }
        ));
        crazyPanel3.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "",
            "[]push[][]",
            "",
            new String[]{
                "width 200"
            }
        ));
        crazyPanel3.add(txtSearch);

        cmdLoad.setText("Load");
        cmdLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoadActionPerformed(evt);
            }
        });
        crazyPanel3.add(cmdLoad);

        cmdAdd.setText("Add New");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });
        crazyPanel3.add(cmdAdd);

        cmdUpdate.setText("Update");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });
        crazyPanel3.add(cmdUpdate);

        cmdDelete.setText("Delete");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });
        crazyPanel3.add(cmdDelete);

        crazyPanel4.add(crazyPanel3);

        Tb_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Người chơi", "Tên Đăng Nhập", "Mật Khẩu", "Email", "Số Tiền Kiếm Được"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tb_User.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(Tb_User);
        if (Tb_User.getColumnModel().getColumnCount() > 0) {
            Tb_User.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        crazyPanel4.add(jScrollPane3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crazyPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crazyPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản Lý Người Chơi", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PL_heard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PL_heard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogOutMouseClicked
        setVisible(false);
        Login loggin = new Login();
        loggin.setVisible(true);
    }//GEN-LAST:event_btn_LogOutMouseClicked


    private void btn_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modeActionPerformed

        if (!FlatLaf.isLafDark()) {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatMacDarkLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });

            btn_mode.setText("Light");
        } else {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatMacLightLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
            btn_mode.setText("Drak");
        }

    }//GEN-LAST:event_btn_modeActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed

        addUser user = new addUser();
        user.setVisible(true);

    }//GEN-LAST:event_cmdAddActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        //them cau hoi

        QuestionDAO qdao = new QuestionDAO();
        StringBuilder sb = new StringBuilder();
        //check null
        List<Question> qsList = qdao.getAllQuestions();

        String question = txt_Ques.getText();
        String topic = txt_Topic.getText();
        String ansCr = txt_AnsCr.getText();
        String ans1 = txt_Ans1.getText();
        String ans2 = txt_Ans2.getText();
        String ans3 = txt_Ans3.getText();
        boolean isCheck = false;
        while (true) {

            if (question.equals("") && topic.equals("") && ansCr.equals("") && ans1.equals("") && ans2.equals("") && ans3.equals("")) {
                sb.append("Không được để trống!");
                break;
            } else if (question.equals("") || topic.equals("") || ansCr.equals("") || ans1.equals("") || ans2.equals("") || ans3.equals("")) {
                sb.append("Không được để trống!");
                break;
            }

            isCheck = true;
            break;
        }

        for (Question q : qsList) {
            if (question.equals(q.getQues())) {
                sb.append("Trung cau hoi");
                isCheck = false;
                break;
            }
        }

        if (isCheck) {
            Question ques = new Question();
            ques.setQues(txt_Ques.getText());
            ques.setTopic(txt_Topic.getText());
            ques.setAnswerCorrect(txt_AnsCr.getText());
            ques.setAnswer1(txt_Ans1.getText());
            ques.setAnswer2(txt_Ans2.getText());
            ques.setAnswer3(txt_Ans3.getText());
            qdao.addQuestion(ques);
            JOptionPane.showMessageDialog(this, "Thêm câu hỏi thành công!");
            txt_Topic.setText("");
            txt_Ques.setText("");
            txt_AnsCr.setText("");
            txt_Ans1.setText("");
            txt_Ans2.setText("");
            txt_Ans3.setText("");

        } else {
            sb.append("Thêm câu hỏi thất bại");
        }

        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }

        getAllQuestion();
    }//GEN-LAST:event_btn_AddActionPerformed

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1KeyPressed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        Player player = new Player();
        for (int row = 0; row < Tb_User.getRowCount(); row++) {
            boolean isFirstColumnValueTrue = (boolean) Tb_User.getValueAt(row, 0);
            if (isFirstColumnValueTrue) {
                Object[] rowData = new Object[Tb_User.getColumnCount()];
                for (int col = 0; col < Tb_User.getColumnCount(); col++) {
                    rowData[col] = Tb_User.getValueAt(row, col);
                }
                //System.out.println("Dữ liệu của dòng có cột đầu tiên là true: " + Arrays.toString(rowData));

                int id = Integer.parseInt(rowData[1].toString());
                String fullName = rowData[2].toString();
                String userName = rowData[3].toString();
                String pass = rowData[4].toString();
                String Email = rowData[5].toString();

                player.setId((int) id);
                player.setFullName(fullName);
                player.setUsername(userName);
                player.setPassword(pass);
                player.setEmail(Email);

                upDateUser adus = new upDateUser(player);
                adus.setVisible(true);

            }
        }

    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed

        for (int row = 0; row < Tb_User.getRowCount(); row++) {
            Boolean isChecked = (Boolean) Tb_User.getValueAt(row, 0);
            if (isChecked) {
                Object value = Tb_User.getValueAt(row, 1);
                deleteUser((int) value);
                //System.out.println("Selected value: " + value);
            }
        }
        getAllUser();
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDelete2ActionPerformed

        for (int row = 0; row < Tb_CauHoi.getRowCount(); row++) {
            Boolean isChecked = (Boolean) Tb_CauHoi.getValueAt(row, 0);
            if (isChecked) {
                Object value = Tb_CauHoi.getValueAt(row, 1);
                deleteQues((int) value);
                // System.out.println("Selected value: " + value);
            }
        }
        getAllQuestion();
    }//GEN-LAST:event_cmdDelete2ActionPerformed

    private void cmdLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoadActionPerformed
        getAllUser();

    }//GEN-LAST:event_cmdLoadActionPerformed

    private void cmdLoad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoad1ActionPerformed
        getAllQuestion();
    }//GEN-LAST:event_cmdLoad1ActionPerformed

    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Boolean.class; // Cột kiểm tra có kiểu boolean
        } else {
            return Object.class; // Cột giá trị có kiểu Object
        }
    }

    public static void main(String args[]) {

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        // FlatMacDarkLaf.setup();
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Admin_System(admin).setVisible(true);
                Admin_System admin_System = new Admin_System(admin);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PL_heard;
    private javax.swing.JTable Tb_CauHoi;
    private javax.swing.JTable Tb_User;
    private javax.swing.JButton btn_Add;
    private javax.swing.JLabel btn_LogOut;
    private javax.swing.JButton btn_mode;
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdDelete2;
    private javax.swing.JButton cmdLoad;
    private javax.swing.JButton cmdLoad1;
    private javax.swing.JButton cmdUpdate;
    private raven.crazypanel.CrazyPanel crazyPanel3;
    private raven.crazypanel.CrazyPanel crazyPanel4;
    private raven.crazypanel.CrazyPanel crazyPanel5;
    private raven.crazypanel.CrazyPanel crazyPanel6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JPasswordField txt_Ans1;
    private javax.swing.JPasswordField txt_Ans2;
    private javax.swing.JTextField txt_Ans3;
    private javax.swing.JPasswordField txt_AnsCr;
    private javax.swing.JTextPane txt_Ques;
    private javax.swing.JTextField txt_Topic;
    // End of variables declaration//GEN-END:variables
}
