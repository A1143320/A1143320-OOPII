import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
public class a1143320java1 {
    static JFrame fre=new JFrame("骰子模擬器");
    static JLabel lab=new JLabel("-",JLabel.CENTER);
    static JLabel in=new JLabel("已知N次,總和M,平均X.XX",JLabel.CENTER);
    static JButton btn=new JButton("擲骰子");
    static int count=0;
    static int sum=0;
    static Random rand=new Random();
    
    public static void main(String[] args){
        BorderLayout bor=new BorderLayout(2,5);
        lab.setFont(new Font("微軟正黑體",Font.BOLD,60));
        fre.setLayout(bor);
        fre.add(lab,BorderLayout.CENTER);
        fre.add(btn,BorderLayout.SOUTH);
        fre.add(in,BorderLayout.NORTH);
        rand.nextInt(6);

        fre.setSize(400,320);
        fre.setLocationRelativeTo(null);
        fre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(new ActLis());
        fre.setVisible(true);
    }
    static class ActLis implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int n=rand.nextInt(6)+1;
            count++;
            sum+=n;
            lab.setText(String.valueOf(n));
            in.setText(String.format("已知%d次,總和%d,平均%.2f",count,sum,(double)sum/count));
        if(n==6){
            lab.setForeground(Color.GREEN);
        }else if(n==1){
            lab.setForeground(Color.RED);
        }else{
            lab.setForeground(Color.BLACK);
        }
        }
    }
}
