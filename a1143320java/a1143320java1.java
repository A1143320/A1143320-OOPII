import javax.swing.*;
import java.awt.*;
public class a1143320java1 {
    static JFrame fre=new JFrame("骰子模擬器");
    public static void main(String[] args){
        BorderLayout bor=new BorderLayout(2,5);
        JLabel lab=new JLabel("目前點數:",JLabel.CENTER);
        lab.setFont(new Font("微軟正黑體",Font.BOLD,60));
        fre.setLayout(bor);
        fre.add(lab,BorderLayout.CENTER);
        fre.add(new JButton("擲骰子"),BorderLayout.SOUTH);
        fre.add(new JLabel("已知N次,總和M,平均X.XX",JLabel.CENTER),BorderLayout.NORTH);

        fre.setSize(400,320);
        fre.setLocationRelativeTo(null);
        fre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fre.setVisible(true);
    }
}
