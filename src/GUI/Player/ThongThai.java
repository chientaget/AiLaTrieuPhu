
package GUI.Player;

import dao.QuestionDAO;
import entity.Question;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;


public class ThongThai extends javax.swing.JFrame {
    private static int currentQuestionIndex;
    
    public ThongThai(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
        initComponents();
        
        QuestionDAO questionDAO = new QuestionDAO();
        List<Question> quesList =  questionDAO.getAllQuestions();
        txt_dapan.setText(quesList.get(currentQuestionIndex).getAnswerCorrect());
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                dispose(); 
            }
        });
        timer.start();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_dapan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel("<html><br>Tôi cũng là người đang  nghiên cứu về lĩnh vực này và  tôi biết chắc đáp án của câu  hỏi này là đáp án:</html>");
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_dapan.setBackground(new java.awt.Color(255, 51, 51));
        txt_dapan.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txt_dapan.setForeground(new java.awt.Color(0, 204, 0));
        txt_dapan.setText("B");
        jPanel1.add(txt_dapan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 160, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ThongThai.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongThai(currentQuestionIndex).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txt_dapan;
    // End of variables declaration//GEN-END:variables
}
