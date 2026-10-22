import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Converter{
    static JFrame frm=new JFrame("單位換算器");
    static JComboBox<String> typeBox=new JComboBox<>(new String[]{"長度","重量","溫度"});
    static JTextField inField=new JTextField(10);
    static JTextField outField=new JTextField(10);
    static JComboBox<String> fromBox=new JComboBox<>();
    static JComboBox<String> toBox=new JComboBox<>();
    static JButton btn=new JButton("換算");

    static String[] lengthUnits={"公尺","公分","英吋","英尺"};
    static String[] weightUnits={"公斤","公克","磅","盎司"};
    static String[] tempUnits={"攝氏","華氏","克氏"};

    static double[] lengthRate={1, 0.01, 0.0254, 0.3048};
    static double[] weightRate={1, 0.001, 0.45359237, 0.028349523};

    public static void main(String[] args){
        frm.setLayout(new BorderLayout());

        JPanel center=new JPanel(new GridLayout(2,1));
        JPanel row1=new JPanel();
        JPanel row2=new JPanel();
        row1.add(inField);
        row1.add(fromBox);
        row2.add(outField);
        row2.add(toBox);
        center.add(row1);
        center.add(row2);

        frm.add(typeBox,BorderLayout.NORTH);
        frm.add(center,BorderLayout.CENTER);
        frm.add(btn,BorderLayout.SOUTH);

        frm.setSize(480,280);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateUnits();  

        typeBox.addActionListener(e -> updateUnits());
        btn.addActionListener(e -> convert());
        outField.setEditable(false);
        frm.setVisible(true);
    }    
    static void convert(){
    double x;
    try{
        x=Double.parseDouble(inField.getText().trim());
    }catch(NumberFormatException ex){
        outField.setText("請輸入數字");
        return;     // 結束方法，不往下算
    }

    int t=typeBox.getSelectedIndex();
    int a=fromBox.getSelectedIndex();
    int b=toBox.getSelectedIndex();
    double result=0;

    if(t==0){
        result=x*lengthRate[a]/lengthRate[b];
    }else if(t==1){
        result=x*weightRate[a]/weightRate[b];
    }else{
        result=convertTemp(x,a,b);
    }

    outField.setText(String.format("%.4f",result));
}
     static double convertTemp(double x,int a,int b){
        double c;   // 先轉成攝氏
        if(a==0){
            c=x;
        }else if(a==1){
            c=(x-32)*5/9;
        }else{
            c=x-273.15;
        }

        if(b==0){
            return c;
        }else if(b==1){
            return c*9/5+32;
        }else{
            return c+273.15;
        }
    }
    static void updateUnits(){
    String[] units;
    int t=typeBox.getSelectedIndex();   // 0長度 1重量 2溫度
    if(t==0){
        units=lengthUnits;
    }else if(t==1){
        units=weightUnits;
    }else{
        units=tempUnits;
    }
    fromBox.removeAllItems();
    toBox.removeAllItems();
    for(String u:units){
        fromBox.addItem(u);
        toBox.addItem(u);
    }
}
}