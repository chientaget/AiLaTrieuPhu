package ailatrieuphu;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
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

public class Admin extends javax.swing.JFrame {

    private int mouseX, mouseY;
    private boolean isFullScreen = false;

    public Admin() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        LOAD();
    }

    void LOAD() {
        // Tạo hiệu ứng shadow cho form
        LineBorder lineBorder = new LineBorder(Color.GRAY, 1, true);
        EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);
        CompoundBorder compoundBorder = new CompoundBorder(lineBorder, emptyBorder);
        PL_heard.setBorder(compoundBorder);

        applyTableStyle(Tb_User);
        testData(Tb_User);
        testData(Tb_CauHoi);
        Tb_User.setSelectionBackground(new Color(102, 102, 255));
        Tb_CauHoi.setSelectionBackground(new Color(102, 102, 255));
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

    // thêm data
    private void testData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(getRandomRow("Beer"));
        model.addRow(getRandomRow("Shirt"));
        model.addRow(getRandomRow("Laptop"));
        model.addRow(getRandomRow("Book"));
        model.addRow(getRandomRow("Coffee"));
        model.addRow(getRandomRow("Phone"));
        model.addRow(getRandomRow("Chair"));
        model.addRow(getRandomRow("Watch"));
        model.addRow(getRandomRow("Sunglasses"));
        model.addRow(getRandomRow("Bag"));
        model.addRow(getRandomRow("Headphones"));
        model.addRow(getRandomRow("Camera"));
        model.addRow(getRandomRow("Necklace"));
        model.addRow(getRandomRow("Perfume"));
        model.addRow(getRandomRow("Wallet"));
        model.addRow(getRandomRow("Jacket"));
        model.addRow(getRandomRow("Bicycle"));
        model.addRow(getRandomRow("Game console"));
        model.addRow(getRandomRow("Tennis racket"));
    }

    // random user name , pass , tiền thưởng
    private Object[] getRandomRow(String name) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        Random ran = new Random();

        int id = ran.nextInt(1000,9999); 
        // Generate random username and password
        String username = generateRandomString(8);  // Change 8 to the desired length
        String password = generateRandomString(12); // Change 12 to the desired length

        // Generate random earnings
        double earnings = (ran.nextInt(9999999 - 9999) + 9999) * ran.nextDouble();
        String formattedEarnings = "$" + df.format(0).replace(",", ".");

        return new Object[]{false, id,name, username, password, formattedEarnings};
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

        //  To Create table alignment
        table.getTableHeader().setDefaultRenderer(getAlignmentCellRender(table.getTableHeader().getDefaultRenderer(), true));
        table.setDefaultRenderer(Object.class, getAlignmentCellRender(table.getDefaultRenderer(Object.class), false));
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

        materialTabbed1 = new tabbed.MaterialTabbed();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_UserName1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_UserName4 = new javax.swing.JPasswordField();
        txt_UserName3 = new javax.swing.JPasswordField();
        txt_UserName5 = new javax.swing.JPasswordField();
        txt_UserName2 = new javax.swing.JPasswordField();
        btn_Add = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tb_CauHoi = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        txtSearch = new javax.swing.JTextField();
        cmdAdd = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tb_User = new javax.swing.JTable();
        PL_heard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_LogOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        materialTabbed1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("ID");

        txt_UserName1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_UserName1.setForeground(new java.awt.Color(51, 51, 51));
        txt_UserName1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_UserName1.setCaretColor(new java.awt.Color(153, 153, 153));
        txt_UserName1.setEchoChar((char) 0);

        jLabel2.setText("Câu Hỏi:");

        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jLabel4.setText("Đáp án đúng");

        jLabel5.setText("Đáp án 2");

        jLabel6.setText("Đáp án 3");

        jLabel7.setText("Đáp án 4");

        txt_UserName4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_UserName4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_UserName4.setEchoChar((char) 0);

        txt_UserName3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_UserName3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_UserName3.setEchoChar((char) 0);

        txt_UserName5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_UserName5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_UserName5.setEchoChar((char) 0);

        txt_UserName2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_UserName2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_UserName2.setEchoChar((char) 0);

        btn_Add.setBackground(new java.awt.Color(0, 0, 0));
        btn_Add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Add.setForeground(new java.awt.Color(255, 255, 255));
        btn_Add.setText("Thêm");
        btn_Add.setBorder(null);
        btn_Add.setBorderPainted(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_UserName3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_UserName2, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_UserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(521, 521, 521))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txt_UserName5, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txt_UserName4, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_UserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_UserName2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_UserName5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(txt_UserName3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(txt_UserName4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        btn_Add.setBorderPainted(false);
        btn_Add.setFocusPainted(false);

        materialTabbed1.addTab("Thêm câu hỏi", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Tb_CauHoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Câu Hỏi", "Đáp Án Đúng", "Đáp án 2", "Đáp án 3", "Đáp án 4"
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
        jScrollPane4.setViewportView(Tb_CauHoi);
        if (Tb_CauHoi.getColumnModel().getColumnCount() > 0) {
            Tb_CauHoi.getColumnModel().getColumn(0).setPreferredWidth(20);
            Tb_CauHoi.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Danh Sách Câu hỏi", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background;[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20",
            null
        ));
        crazyPanel1.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fill,insets 15",
            "[fill]",
            "[grow 0][fill]",
            null
        ));

        crazyPanel2.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background",
            new String[]{
                "JTextField.placeholderText=Search;background:@background",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1"
            }
        ));
        crazyPanel2.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "",
            "[]push[][]",
            "",
            new String[]{
                "width 200"
            }
        ));
        crazyPanel2.add(txtSearch);

        cmdAdd.setText("Add New");
        crazyPanel2.add(cmdAdd);

        cmdUpdate.setText("Update");
        crazyPanel2.add(cmdUpdate);

        cmdDelete.setText("Delete");
        crazyPanel2.add(cmdDelete);

        crazyPanel1.add(crazyPanel2);

        Tb_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Người chơi", "Tên Đăng Nhập", "Mật Khẩu", "Số Tiền Kiếm Được"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Tb_User);
        if (Tb_User.getColumnModel().getColumnCount() > 0) {
            Tb_User.getColumnModel().getColumn(0).setPreferredWidth(20);
            Tb_User.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        crazyPanel1.add(jScrollPane2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Quản Lý Người Chơi", jPanel3);

        PL_heard.setBackground(new java.awt.Color(102, 102, 255));
        PL_heard.setAlignmentX(0.0F);
        PL_heard.setAlignmentY(0.0F);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMIN");

        btn_LogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout Rounded.png"))); // NOI18N

        javax.swing.GroupLayout PL_heardLayout = new javax.swing.GroupLayout(PL_heard);
        PL_heard.setLayout(PL_heardLayout);
        PL_heardLayout.setHorizontalGroup(
            PL_heardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PL_heardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(274, 274, 274)
                .addComponent(btn_LogOut)
                .addGap(19, 19, 19))
        );
        PL_heardLayout.setVerticalGroup(
            PL_heardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PL_heardLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PL_heardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_LogOut)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PL_heard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PL_heard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        materialTabbed1.getAccessibleContext().setAccessibleName("Danh Sách Câu Hỏi");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Admin().setVisible(true);
            }
        });
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
         */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PL_heard;
    private javax.swing.JTable Tb_CauHoi;
    private javax.swing.JTable Tb_User;
    private javax.swing.JButton btn_Add;
    private javax.swing.JLabel btn_LogOut;
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdUpdate;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private tabbed.MaterialTabbed materialTabbed1;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JPasswordField txt_UserName1;
    private javax.swing.JPasswordField txt_UserName2;
    private javax.swing.JPasswordField txt_UserName3;
    private javax.swing.JPasswordField txt_UserName4;
    private javax.swing.JPasswordField txt_UserName5;
    // End of variables declaration//GEN-END:variables
}
