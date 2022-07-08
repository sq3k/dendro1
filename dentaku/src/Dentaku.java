package dentaku.src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dentaku extends javax.swing.JFrame{
  
    private static final long serialVersionUID=1L;
    JPanel contentPane=new JPanel();
    BorderLayout borderLayout1=new BorderLayout();
    JTextField result=new JTextField("");//計算結果を表示するテキストフィールド

    //フレームのビルド
    public Dentaku(){
       contentPane.setLayout(borderLayout1);
       this.setSize(new Dimension(250,300));
       this.setTitle("電卓");
       this.setContentPane(contentPane);
       contentPane.add(result,BorderLayout.NORTH);//テキストフィールドを配置
       JPanel keyPanel=new JPanel();//ボタンを配置するパネルを用意
              keyPanel.setLayout(new GridLayout(5,4));//4行4列のGridLayoutにする
       contentPane.add(keyPanel,BorderLayout.CENTER);
       keyPanel.add(new JButton("de"),0);
       keyPanel.add(new JButton(" "),1);
       keyPanel.add(new JButton(" "),2);
       keyPanel.add(new JButton("÷"),3);

       keyPanel.add(new JButton("7"),4);
       keyPanel.add(new JButton("8"),5);
       keyPanel.add(new JButton("9"),6);
       keyPanel.add(new JButton("×"),7);

       keyPanel.add(new JButton("4"),8);
       keyPanel.add(new JButton("5"),9);
       keyPanel.add(new JButton("6"),10);
       keyPanel.add(new JButton("-"),11);

       keyPanel.add(new JButton("1"),12);
       keyPanel.add(new JButton("2"),13);
       keyPanel.add(new JButton("3"),14);
       keyPanel.add(new JButton("+"),15);
    
 
       keyPanel.add(new JButton("0"),16);
       keyPanel.add(new JButton(" "),17);
       keyPanel.add(new JButton(" "),18);
       keyPanel.add(new JButton("="),19);
       
       
       this.setVisible(true);

       
    }
    

  }

