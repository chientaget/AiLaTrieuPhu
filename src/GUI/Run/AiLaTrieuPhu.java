package GUI.Run;

import GUI.Log_Reg.Login;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import entity.Person;
import entity.Player;
import entity.Question;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.UIManager;

public class AiLaTrieuPhu {

    public static void main(String[] args) {

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableview");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        start_Game g = new start_Game();
        g.setVisible(true);

        // Đợi 3 giây trước khi hiển thị cửa sổ Login
        Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login lg = new Login();
                lg.setVisible(true);
            }
        });

        timer.setRepeats(false); // Không lặp lại timer sau khi chạy xong
        timer.start();
    }
}
