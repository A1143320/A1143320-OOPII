import javax.swing.*;
import java.awt.*;

public class BadLogin extends JFrame {
    public BadLogin() {
        setTitle("登入");
        setSize(320, 240);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 關閉視窗時結束程式
        setLocationRelativeTo(null); // 讓視窗置中顯示

        // 帳號標籤與輸入框
        JLabel l1 = new JLabel("帳號:");
        l1.setBounds(40, 30, 60, 25);
        JTextField t1 = new JTextField();
        t1.setBounds(100, 30, 150, 25);

        // 密碼標籤與輸入框
        JLabel l2 = new JLabel("密碼:");
        l2.setBounds(40, 70, 60, 25);
        JPasswordField t2 = new JPasswordField(); // 建議改用密碼欄位
        t2.setBounds(100, 70, 150, 25);

        // 登入按鈕
        JButton btn = new JButton("登入");
        btn.setBounds(100, 120, 100, 30);

        // 加入元件至視窗
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(btn);

        // 點擊事件處理
        btn.addActionListener(e -> {
            String username = t1.getText();
            String password = new String(t2.getPassword());

            // 使用 .equals() 比對字串內容
            if ("admin".equals(username) && "1234".equals(password)) {
                System.out.println("登入成功");
                JOptionPane.showMessageDialog(this, "登入成功！");
            } else {
                System.out.println("帳號或密碼錯誤");
                JOptionPane.showMessageDialog(this, "帳號或密碼錯誤", "錯誤", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 所有元件與事件設定完成後再顯示視窗
        setVisible(true);
    }

    public static void main(String[] args) {
        new BadLogin();
    }
}