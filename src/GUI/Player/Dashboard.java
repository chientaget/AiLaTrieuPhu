package GUI.Player;

import dao.PlayerDAO;
import dao.PriceDAO;
import dao.QuestionDAO;
import entity.Player;
import entity.Price;
import entity.Question;
import jaco.mp3.player.MP3Player;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Dashboard extends javax.swing.JFrame {

    Icon ques1 = new ImageIcon(getClass().getClassLoader().getResource("img/ques1.png"));
    Icon ques2 = new ImageIcon(getClass().getClassLoader().getResource("img/ques2.png"));
    Icon ques3 = new ImageIcon(getClass().getClassLoader().getResource("img/ques3.png"));
    Icon ques4 = new ImageIcon(getClass().getClassLoader().getResource("img/ques4.png"));
    Icon t5050 = new ImageIcon(getClass().getClassLoader().getResource("img/true5050.png"));
    Icon f5050 = new ImageIcon(getClass().getClassLoader().getResource("img/F5050.png"));

    Icon tcall = new ImageIcon(getClass().getClassLoader().getResource("img/Tcall.png"));
    Icon fcall = new ImageIcon(getClass().getClassLoader().getResource("img/Fcall.png"));
    Icon tKhanGia = new ImageIcon(getClass().getClassLoader().getResource("img/TKhanGia.png"));
    Icon fKhanGia = new ImageIcon(getClass().getClassLoader().getResource("img/FKhanGia.png"));
    Icon tThongThai = new ImageIcon(getClass().getClassLoader().getResource("img/TThongThai.png"));
    Icon fThongThai = new ImageIcon(getClass().getClassLoader().getResource("img/FThongThai.png"));
    public static Player player;

    // sound âm thanh cho game
    ClassLoader classLoader = getClass().getClassLoader();

    URL BATDAU = classLoader.getResource("Audio/batdau.mp3");
    URL INCORRECT = classLoader.getResource("Audio/victorySound.mp3");
    URL SAI = classLoader.getResource("Audio/sai.mp3");
    URL Dung = classLoader.getResource("Audio/corectSound.mp3");
    URL NEN = classLoader.getResource("Audio/nen.mp3");

    File fBatDau = new File(BATDAU.getFile());
    File vic = new File(INCORRECT.getFile());
    File sai = new File(SAI.getFile());
    File dung = new File(Dung.getFile());
    File nen = new File(NEN.getFile());

    MP3Player playerBatDau = new MP3Player(fBatDau);
    MP3Player pvic = new MP3Player(vic);
    MP3Player psai = new MP3Player(sai);
    MP3Player pdung = new MP3Player(dung);
    MP3Player pnen = new MP3Player(nen);

    private JLabel[] txt_ans;
    private int currentQuestionIndex;
    //lay du lieu cau hoi va gia tien tu db

    QuestionDAO questionDAO = new QuestionDAO();
    PriceDAO priceDAO = new PriceDAO();
    PlayerDAO playerDao = new PlayerDAO();

    List<Price> priceList = priceDAO.getAllPrices();
    List<Question> quesList = questionDAO.getAllQuestions();

    public Dashboard(Player player) {
        pnen.play();
        this.player = player;
        initComponents();
        txt_name.setText(player.getFullName());
        a1.setContentAreaFilled(false);
        a2.setContentAreaFilled(false);
        a3.setContentAreaFilled(false);
        a4.setContentAreaFilled(false);
        x.setContentAreaFilled(false);
        jButton6.setContentAreaFilled(false);
        jButton7.setContentAreaFilled(false);
        jButton8.setContentAreaFilled(false);
        jButton9.setContentAreaFilled(false);

        currentQuestionIndex = 0;
        showQuestion(0);
    }

    private void showQuestion(int index) {

        if (index >= 0 && index < quesList.size()) {
            Question ques = quesList.get(index);
            txt_ques.setText(ques.getQues());

            List<String> ansList = new ArrayList<>();
            ansList.add(ques.getAnswer1());
            ansList.add(ques.getAnswerCorrect());
            ansList.add(ques.getAnswer2());
            ansList.add(ques.getAnswer3());
            Collections.shuffle(ansList);

            //hien random cau tra loi
            txt_ans1.setText(ansList.get(0));
            txt_ans2.setText(ansList.get(1));
            txt_ans3.setText(ansList.get(2));
            txt_ans4.setText(ansList.get(3));
            //set cusor 
            txt_ans1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            txt_ans2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            txt_ans3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            txt_ans4.setCursor(new Cursor(Cursor.HAND_CURSOR));

            txt_ans1.addMouseListener(new AnswerLabelMouseListener());
            txt_ans2.addMouseListener(new AnswerLabelMouseListener());
            txt_ans3.addMouseListener(new AnswerLabelMouseListener());
            txt_ans4.addMouseListener(new AnswerLabelMouseListener());

        }
        txt_userMoney.setText(getPriceById(index));
        player.setTotalMoney(txt_userMoney.getText());
        txt_money.setText(getPriceById(index + 1));

    }
    private boolean win = false;
    private boolean isListening = true; // Kiểm tra xem có đang đợi click hay không

    private class AnswerLabelMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (isListening) {
                JLabel clickedLabel = (JLabel) e.getSource();
                String selectedAnswer = clickedLabel.getText();
                String da = clickedLabel.getToolTipText();

                win = false;
                StringBuilder sb = new StringBuilder();
                if (selectedAnswer.equals(quesList.get(currentQuestionIndex).getAnswerCorrect())) {
                    JOptionPane.showMessageDialog(null, "Chính xác!");
                    pdung.play();
                    animationTRUE(da);
                    // Tạo một Timer với khoảng thời gian 5 giây (5000 milliseconds)
                    Timer timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            animationmd(da);
                            //check theo tung moc
                            if (quesList.get(currentQuestionIndex).getId() == 5) {
                                int choice = JOptionPane.showConfirmDialog(null, "Nếu trả lời sai bạn sẽ phải ra về với 1.000.000 \n nếu bạn lựa chọn dừng cuộc chơi thì số tiền thưởng hiện tại bạn đang có sẽ là của bạn?\n bạn có muốn tiếp tục không", "Mốc câu hỏi từ 1.000.000 - 10.000.000!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                if (choice == JOptionPane.YES_OPTION) {

                                } else {

                                    win = true;
                                    EndGame egd = new EndGame(player);
                                    Dashboard.this.setVisible(false);
                                    egd.setVisible(true);
                                }
                            } else if (quesList.get(currentQuestionIndex).getId() == 10) {
                                int choice = JOptionPane.showConfirmDialog(null, "Nếu trả lời sai bạn sẽ phải ra về với 14.000.000 \n nếu bạn lựa chọn dừng cuộc chơi thì số tiền thưởng hiện tại bạn đang có sẽ là của bạn?\n bạn có muốn tiếp tục không", "Mốc câu hỏi từ 1.000.000 - 10.000.000!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                if (choice == JOptionPane.YES_OPTION) {

                                } else {

                                    win = true;
                                    EndGame egd = new EndGame(player);
                                    Dashboard.this.setVisible(false);
                                    egd.setVisible(true);
                                }
                            } else if (quesList.get(currentQuestionIndex).getId() == 15) {
                                int choice = JOptionPane.showConfirmDialog(null, "Nếu trả lời sai bạn sẽ phải ra về với 14.000.000 \n nếu bạn lựa chọn dừng cuộc chơi thì số tiền thưởng hiện tại bạn đang có sẽ là của bạn?\n bạn có muốn tiếp tục không", "Mốc câu hỏi từ 1.000.000 - 10.000.000!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                if (choice == JOptionPane.YES_OPTION) {

                                } else {

                                    win = true;
                                    EndGame egd = new EndGame(player);
                                    Dashboard.this.setVisible(false);
                                    egd.setVisible(true);
                                }
                            } //hoàn thành 15 câu
                            else if (quesList.get(currentQuestionIndex).getId() > 15) {

                                player.setTotalMoney(getPriceById(15));
                                playerDao.updateMoneyOfPlayer(player);
                                sb.append("XIN CHÚC MỪNG BẠN ĐÃ TRỞ THÀNH TRIỆU PHÚ!");
                                Dashboard.this.setVisible(false);
                                EndGame egd = new EndGame(player);
                                egd.setVisible(true);
                                Dashboard.this.setVisible(false);
                                if (sb.length() > 0) {
                                    JOptionPane.showMessageDialog(null, sb.toString());
                                    return;
                                }
                                win = true;
                            }
                            player.setTotalMoney(txt_money.getText());
                            playerDao.updateMoneyOfPlayer(player);
                            currentQuestionIndex++;
                            txt_money.setText(getPriceById(currentQuestionIndex));
                            txt_userMoney.setText(getPriceById(currentQuestionIndex - 1));
                            if (currentQuestionIndex < quesList.size()) {
                                showQuestion(currentQuestionIndex);
                            } else {
                                JOptionPane.showMessageDialog(null, "Chúc mừng bạn đã trở thành triệu phú!");
                                System.exit(0); // Khi kết thúc trò chơi thành công
                            }
                        }
                    });

                    timer.setRepeats(false);
                    timer.start();

                } else {
                    animationFALSE(da);
                    psai.play();
                    Timer timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            animationmd(da);
                            JOptionPane.showMessageDialog(null, "Rất tiếc, câu trả lời không đúng!");
                            player.setTotalMoney(txt_userMoney.getText());
                            playerDao.updateMoneyOfPlayer(player);

                            EndGame eg = new EndGame(player);
                            eg.setVisible(true);
                        }
                    });

                    timer.setRepeats(false);
                    timer.start();

                }
                if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(null, sb.toString());
                    return;
                }

                // dừng nhận click 1 s
                isListening = false;
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        isListening = true;
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }

    }

    private String getPriceById(int id) {
        for (Price price : priceList) {
            if (price.getId() == id) {
                return price.getPrice();
            }
        }
        return "";
    }
    int st = 1;

    void setOp() {
        switch (st) {
            case 1:
                txt_t1.setOpaque(true);
                break;
            case 2:
                txt_t1.setOpaque(false);
                txt_t2.setOpaque(true);
                break;
            case 3:
                txt_t2.setOpaque(false);
                txt_t3.setOpaque(true);
                break;
            case 4:
                txt_t3.setOpaque(false);
                txt_t4.setOpaque(true);
                break;
            case 5:
                txt_t4.setOpaque(false);
                txt_t5.setOpaque(true);
                break;
            case 6:
                txt_t5.setOpaque(false);
                txt_t6.setOpaque(true);
                break;
            case 7:
                txt_t6.setOpaque(false);
                txt_t7.setOpaque(true);
                break;
            case 8:
                txt_t7.setOpaque(false);
                txt_t8.setOpaque(true);
                break;
            case 9:
                txt_t8.setOpaque(false);
                txt_t9.setOpaque(true);
                break;
            case 10:
                txt_t9.setOpaque(false);
                txt_t10.setOpaque(true);
                break;
            case 11:
                txt_t10.setOpaque(false);
                txt_t11.setOpaque(true);
                break;
            case 12:
                txt_t11.setOpaque(false);
                txt_t12.setOpaque(true);
                break;
            case 13:
                txt_t12.setOpaque(false);
                txt_t13.setOpaque(true);
                break;
            case 14:
                txt_t13.setOpaque(false);
                txt_t14.setOpaque(true);
                break;
            case 15:
                txt_t14.setOpaque(false);
                txt_t15.setOpaque(true);
                break;
            default:
                break;
        }
        st++;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_ans1 = new javax.swing.JLabel();
        txt_ans2 = new javax.swing.JLabel();
        txt_ans3 = new javax.swing.JLabel();
        txt_ans4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        txt_name = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_userMoney = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_money = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_t4 = new javax.swing.JLabel();
        txt_t14 = new javax.swing.JLabel();
        txt_t3 = new javax.swing.JLabel();
        txt_t13 = new javax.swing.JLabel();
        txt_t2 = new javax.swing.JLabel();
        txt_t12 = new javax.swing.JLabel();
        txt_t1 = new javax.swing.JLabel();
        txt_t11 = new javax.swing.JLabel();
        txt_t10 = new javax.swing.JLabel();
        txt_t9 = new javax.swing.JLabel();
        txt_t8 = new javax.swing.JLabel();
        txt_t7 = new javax.swing.JLabel();
        txt_t6 = new javax.swing.JLabel();
        txt_t5 = new javax.swing.JLabel();
        txt_t15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_ques = new javax.swing.JLabel("<html><br>câu hỏi</html>");
        x = new javax.swing.JButton();
        a1 = new javax.swing.JButton();
        a2 = new javax.swing.JButton();
        a3 = new javax.swing.JButton();
        a4 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ans1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ans1.setForeground(new java.awt.Color(255, 255, 255));
        txt_ans1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ans1.setText("A.Hà Nội");
        txt_ans1.setToolTipText("A");
        getContentPane().add(txt_ans1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 530, 310, 60));

        txt_ans2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ans2.setForeground(new java.awt.Color(255, 255, 255));
        txt_ans2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ans2.setText("A.Hà Nội");
        txt_ans2.setToolTipText("B");
        getContentPane().add(txt_ans2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, 310, 60));

        txt_ans3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ans3.setForeground(new java.awt.Color(255, 255, 255));
        txt_ans3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ans3.setText("A.Hà Nội");
        txt_ans3.setToolTipText("C");
        getContentPane().add(txt_ans3, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 650, 300, 60));

        txt_ans4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ans4.setForeground(new java.awt.Color(255, 255, 255));
        txt_ans4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ans4.setText("A.Hà Nội");
        txt_ans4.setToolTipText("D");
        getContentPane().add(txt_ans4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 650, 300, 60));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/TCall.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 80, 80));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/TKhanGia.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 80, 80));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/TThongThai.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 80, 80));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/true5050_1.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 80, 80));

        txt_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setText("Nguyễn Hoàng Nam");
        jPanel1.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salary male.png"))); // NOI18N
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        txt_userMoney.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_userMoney.setForeground(new java.awt.Color(255, 255, 255));
        txt_userMoney.setText("Số tiền hiện tại:");
        jPanel1.add(txt_userMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 140, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Mức câu hỏi giá:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 190, 40));

        txt_money.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_money.setForeground(new java.awt.Color(255, 255, 51));
        txt_money.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_money.setText("0");
        jPanel1.add(txt_money, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 190, 40));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg_Question.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 290, 510));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_t4.setBackground(new java.awt.Color(102, 102, 255));
        txt_t4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t4.setForeground(new java.awt.Color(228, 166, 45));
        txt_t4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t4.setText("4     8.000.000 VNĐ");
        jPanel2.add(txt_t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 210, 30));

        txt_t14.setBackground(new java.awt.Color(102, 102, 255));
        txt_t14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t14.setForeground(new java.awt.Color(228, 166, 45));
        txt_t14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t14.setText("14    85.000.000 VNĐ");
        jPanel2.add(txt_t14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 210, 30));

        txt_t3.setBackground(new java.awt.Color(102, 102, 255));
        txt_t3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t3.setForeground(new java.awt.Color(228, 166, 45));
        txt_t3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t3.setText("3     600.000 VNĐ");
        jPanel2.add(txt_t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 210, 30));

        txt_t13.setBackground(new java.awt.Color(102, 102, 255));
        txt_t13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t13.setForeground(new java.awt.Color(228, 166, 45));
        txt_t13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t13.setText("13    40.000.000 VNĐ");
        jPanel2.add(txt_t13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 210, 30));

        txt_t2.setBackground(new java.awt.Color(102, 102, 255));
        txt_t2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t2.setForeground(new java.awt.Color(228, 166, 45));
        txt_t2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t2.setText("2     400.000 VNĐ");
        jPanel2.add(txt_t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 210, 30));

        txt_t12.setBackground(new java.awt.Color(102, 102, 255));
        txt_t12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t12.setForeground(new java.awt.Color(228, 166, 45));
        txt_t12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t12.setText("12    30.000.000 VNĐ");
        jPanel2.add(txt_t12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 210, 30));

        txt_t1.setBackground(new java.awt.Color(102, 102, 255));
        txt_t1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t1.setForeground(new java.awt.Color(228, 166, 45));
        txt_t1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t1.setText("1     200.000 VNĐ");
        txt_t1.setAlignmentX(5.0F);
        txt_t1.setAlignmentY(5.0F);
        txt_t1.setOpaque(false);
        jPanel2.add(txt_t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 210, 30));

        txt_t11.setBackground(new java.awt.Color(102, 102, 255));
        txt_t11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t11.setForeground(new java.awt.Color(228, 166, 45));
        txt_t11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t11.setText("11    22.000.000 VNĐ");
        jPanel2.add(txt_t11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 210, 30));

        txt_t10.setBackground(new java.awt.Color(102, 102, 255));
        txt_t10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t10.setForeground(new java.awt.Color(255, 255, 255));
        txt_t10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t10.setText("10    14.000.000 VNĐ");
        jPanel2.add(txt_t10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 210, 30));

        txt_t9.setBackground(new java.awt.Color(102, 102, 255));
        txt_t9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t9.setForeground(new java.awt.Color(228, 166, 45));
        txt_t9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t9.setText("9     10.000.000 VNĐ");
        jPanel2.add(txt_t9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 210, 30));

        txt_t8.setBackground(new java.awt.Color(102, 102, 255));
        txt_t8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t8.setForeground(new java.awt.Color(228, 166, 45));
        txt_t8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t8.setText("8     6.000.000 VNĐ");
        jPanel2.add(txt_t8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 210, 30));

        txt_t7.setBackground(new java.awt.Color(102, 102, 255));
        txt_t7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t7.setForeground(new java.awt.Color(228, 166, 45));
        txt_t7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t7.setText("7     3.000.000 VNĐ");
        jPanel2.add(txt_t7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 210, 30));

        txt_t6.setBackground(new java.awt.Color(102, 102, 255));
        txt_t6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t6.setForeground(new java.awt.Color(228, 166, 45));
        txt_t6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t6.setText("6     2.000.000 VNĐ");
        jPanel2.add(txt_t6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 210, 30));

        txt_t5.setBackground(new java.awt.Color(102, 102, 255));
        txt_t5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t5.setForeground(new java.awt.Color(255, 255, 255));
        txt_t5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t5.setText("5     1.000.000 VNĐ");
        jPanel2.add(txt_t5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 210, 30));

        txt_t15.setBackground(new java.awt.Color(102, 102, 255));
        txt_t15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_t15.setForeground(new java.awt.Color(255, 255, 255));
        txt_t15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_t15.setText("15    150.000.000 VNĐ");
        jPanel2.add(txt_t15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 210, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg_Ques001.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 530));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 320, 570));

        txt_ques.setForeground(new java.awt.Color(255, 255, 255));
        txt_ques.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ques.setText("Câu hỏi");
        txt_ques.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txt_ques, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 600, 160));

        x.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cauhoi.png"))); // NOI18N
        x.setBorder(null);
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });
        getContentPane().add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 600, 160));

        a1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ques1.png"))); // NOI18N
        a1.setBorder(null);
        a1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1ActionPerformed(evt);
            }
        });
        getContentPane().add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 530, -1, -1));

        a2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ques1.png"))); // NOI18N
        a2.setBorder(null);
        a2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a2ActionPerformed(evt);
            }
        });
        getContentPane().add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, -1, -1));

        a3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ques1.png"))); // NOI18N
        a3.setBorder(null);
        a3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3ActionPerformed(evt);
            }
        });
        getContentPane().add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 650, -1, -1));

        a4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ques1.png"))); // NOI18N
        a4.setBorder(null);
        a4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4ActionPerformed(evt);
            }
        });
        getContentPane().add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 650, -1, -1));

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        jLabel31.setToolTipText("");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 1380, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 665, 1380, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LGO.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 200, 200));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        jLabel9.setToolTipText("");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 546, 1380, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg1.png"))); // NOI18N
        BG.setOpaque(true);
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 760));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg_Question.png"))); // NOI18N
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, 280, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private Timer timer;
    private boolean icon1Active = true;
    private int blinkCount = 0;

    private void a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a1ActionPerformed

    }//GEN-LAST:event_a1ActionPerformed

    private void a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a2ActionPerformed

    }//GEN-LAST:event_a2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton6.setIcon(fcall);

        Call call = new Call();
        call.setVisible(true);
        jButton6.setEnabled(false);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7.setIcon(fKhanGia);
        KhanGia kg = new KhanGia();
        kg.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jButton8.setIcon(fThongThai);
        ThongThai thongThai = new ThongThai(currentQuestionIndex);
        thongThai.setVisible(true);
        jButton8.setEnabled(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // 5050
        String imagePath2 = "img/ques2.png";
        Icon icon2 = new ImageIcon(getClass().getClassLoader().getResource(imagePath2));
        jButton9.setIcon(f5050);
        Question ques = new Question();
        for (int i = 0; i < quesList.size(); i++) {
            if (quesList.get(i).getId() == currentQuestionIndex + 1) {
                ques = quesList.get(i);
                break;
            }
        }
        if (!txt_ans1.getText().equals(ques.getAnswerCorrect()) && !txt_ans2.getText().equals(ques.getAnswerCorrect())) {
            txt_ans1.setText("");
            txt_ans2.setText("");
//                a1.setIcon(icon2);
//                a2.setIcon(icon2);
        } else if (!txt_ans2.getText().equals(ques.getAnswerCorrect()) && !txt_ans3.getText().equals(ques.getAnswerCorrect())) {
            txt_ans2.setText("");
            txt_ans3.setText("");
//                a2.setIcon(icon2);
//                a3.setIcon(icon2);
        } else if (!txt_ans3.getText().equals(ques.getAnswerCorrect()) && !txt_ans4.getText().equals(ques.getAnswerCorrect())) {
            txt_ans3.setText("");
            txt_ans4.setText("");
//                a3.setIcon(icon2);
//                a4.setIcon(icon2);
        } else if (!txt_ans1.getText().equals(ques.getAnswerCorrect()) && !txt_ans4.getText().equals(ques.getAnswerCorrect())) {
            txt_ans1.setText("");
            txt_ans4.setText("");
//                a1.setIcon(icon2);
//                a4.setIcon(icon2);
        } else if (!txt_ans1.getText().equals(ques.getAnswerCorrect()) && !txt_ans3.getText().equals(ques.getAnswerCorrect())) {
            txt_ans1.setText("");
            txt_ans3.setText("");
//                a1.setIcon(icon2);
//                a3.setIcon(icon2);
        } else if (!txt_ans2.getText().equals(ques.getAnswerCorrect()) && !txt_ans4.getText().equals(ques.getAnswerCorrect())) {
            txt_ans2.setText("");
            txt_ans4.setText("");
//                a2.setIcon(icon2);
//                a4.setIcon(icon2);
        }

        jButton9.setEnabled(false);

    }//GEN-LAST:event_jButton9ActionPerformed


    private void a3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a3ActionPerformed

    }//GEN-LAST:event_a3ActionPerformed

    private void a4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a4ActionPerformed


    }//GEN-LAST:event_a4ActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xActionPerformed
    void animationTRUE(String DapAn) {

        if (DapAn == "A") {
            NHapNhayTrue(a1);
        } else if (DapAn == "B") {
            NHapNhayTrue(a2);
        } else if (DapAn == "C") {
            NHapNhayTrue(a3);
        } else if (DapAn == "D") {
            NHapNhayTrue(a4);
        }
    }

    void animationFALSE(String DapAn) {

        if (DapAn == "A") {
            NHapNhayFalse(a1);
        } else if (DapAn == "B") {
            NHapNhayFalse(a2);
        } else if (DapAn == "C") {
            NHapNhayFalse(a3);
        } else if (DapAn == "D") {
            NHapNhayFalse(a4);
        }
    }

    void setMD(JButton btn) {

        String imagePath1 = "img/ques1.png";
        Icon icon1 = new ImageIcon(getClass().getClassLoader().getResource(imagePath1));
        btn.setIcon(icon1);
    }

    void animationmd(String DapAn) {

        if (DapAn == "A") {
            setMD(a1);
        } else if (DapAn == "B") {
            setMD(a2);
        } else if (DapAn == "C") {
            setMD(a3);
        } else if (DapAn == "D") {
            setMD(a4);
        }
    }

    public void NHapNhayTrue(JButton btn) {
        String imagePath1 = "img/ques1.png";
        String imagePath2 = "img/ques2.png";
        String imagePath3 = "img/ques3.png";

        Icon icon1 = new ImageIcon(getClass().getClassLoader().getResource(imagePath1));
        Icon icon2 = new ImageIcon(getClass().getClassLoader().getResource(imagePath2));
        Icon icon3 = new ImageIcon(getClass().getClassLoader().getResource(imagePath3));
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (blinkCount < 10) {
                    if (icon1Active) {
                        btn.setIcon(icon2);
                    } else {
                        btn.setIcon(icon3);
                    }
                    icon1Active = !icon1Active;
                    blinkCount++;
                } else {
                    timer.stop();
                }
            }
        });
        timer.setRepeats(true);
        // Bắt đầu hiệu ứng nhấp nháy khi nút được nhấp
        blinkCount = 0;
        timer.start();
        //btn.setIcon(icon1);
    }

    public void NHapNhayFalse(JButton btn) {
        String imagePath1 = "img/ques1.png";
        String imagePath2 = "img/ques2.png";
        String imagePath4 = "img/ques4.png";

        Icon icon1 = new ImageIcon(getClass().getClassLoader().getResource(imagePath1));
        Icon icon2 = new ImageIcon(getClass().getClassLoader().getResource(imagePath2));
        Icon icon4 = new ImageIcon(getClass().getClassLoader().getResource(imagePath4));
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (blinkCount < 10) {
                    if (icon1Active) {
                        btn.setIcon(icon2);
                    } else {
                        btn.setIcon(icon4);
                    }
                    icon1Active = !icon1Active;
                    blinkCount++;
                } else {
                    timer.stop();
                }
            }
        });
        timer.setRepeats(true);
        // Bắt đầu hiệu ứng nhấp nháy khi nút được nhấp
        blinkCount = 0;
        timer.start();
        //btn.setIcon(icon1);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(player).setVisible(true);
                Dashboard d = new Dashboard(player);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton a1;
    private javax.swing.JButton a2;
    private javax.swing.JButton a3;
    private javax.swing.JButton a4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txt_ans1;
    private javax.swing.JLabel txt_ans2;
    private javax.swing.JLabel txt_ans3;
    private javax.swing.JLabel txt_ans4;
    private javax.swing.JLabel txt_money;
    private javax.swing.JLabel txt_name;
    private javax.swing.JLabel txt_ques;
    private javax.swing.JLabel txt_t1;
    private javax.swing.JLabel txt_t10;
    private javax.swing.JLabel txt_t11;
    private javax.swing.JLabel txt_t12;
    private javax.swing.JLabel txt_t13;
    private javax.swing.JLabel txt_t14;
    private javax.swing.JLabel txt_t15;
    private javax.swing.JLabel txt_t2;
    private javax.swing.JLabel txt_t3;
    private javax.swing.JLabel txt_t4;
    private javax.swing.JLabel txt_t5;
    private javax.swing.JLabel txt_t6;
    private javax.swing.JLabel txt_t7;
    private javax.swing.JLabel txt_t8;
    private javax.swing.JLabel txt_t9;
    private javax.swing.JLabel txt_userMoney;
    private javax.swing.JButton x;
    // End of variables declaration//GEN-END:variables
}
