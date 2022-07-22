//package dentaku.src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dentaku extends javax.swing.JFrame{
  
    private static final long serialVersionUID=1L;
    JPanel contentPane=new JPanel();
    BorderLayout borderLayout1=new BorderLayout();
    JTextField result=new JTextField("0");//計算結果を表示するテキストフィールド
    double stackedValue = 0.0; //演算子ボタンを押す前にテキストフィールドにあった値
	 boolean isStacked = false; //stackedValueに数値を入力したかどうか
	 boolean afterCalc = false; //演算子ボタンを押した後かどうか
	 String currentOp = ""; //押された演算子ボタンの名前

    //フレームのビルド
    public Dentaku(){
       contentPane.setLayout(borderLayout1);
       this.setSize(new Dimension(250,300));
       this.setTitle("電卓");
       this.setContentPane(contentPane);
       contentPane.add(result,BorderLayout.NORTH);//テキストフィールドを配置
       JPanel keyPanel=new JPanel();//ボタンを配置するパネルを用意
       keyPanel.setLayout(new GridLayout(5,4));//5行4列のGridLayoutにする
       contentPane.add(keyPanel,BorderLayout.CENTER);
       keyPanel.add(new ClearButton(),0);
       keyPanel.add(new JButton(" "),1);
       keyPanel.add(new JButton(" "),2);
       keyPanel.add(new CalcButton("÷"),3);

       keyPanel.add(new NumberButton("7"),4);
       keyPanel.add(new NumberButton("8"),5);
       keyPanel.add(new NumberButton("9"),6);
       keyPanel.add(new CalcButton("x"),7);

       keyPanel.add(new NumberButton("4"),8);
       keyPanel.add(new NumberButton("5"),9);
       keyPanel.add(new NumberButton("6"),10);
       keyPanel.add(new CalcButton("-"),11);

       keyPanel.add(new NumberButton("1"),12);
       keyPanel.add(new NumberButton("2"),13);
       keyPanel.add(new NumberButton("3"),14);
       keyPanel.add(new CalcButton("+"),15);
    
 
       keyPanel.add(new NumberButton("0"),16);
       keyPanel.add(new JButton(" "),17);
       keyPanel.add(new JButton(" "),18);
       keyPanel.add(new CalcButton("="),19);
       
       
       this.setVisible(true);
    }
/* テキストフィールドに引数の文字列をつなげる */
public void appendResult(String c) {
   String str="null";
   String ze = "0";
   String error="エラー";
   if (!afterCalc) {//演算子ボタンを押した直後でないなら
      if(!str.equals(result.getText()) ){
        if(ze.equals(result.getText())){
           result.setText(c);
           afterCalc=false;
        }
        else if(error.equals(result.getText())){
         afterCalc=true;
        }
        else{
		  result.setText(result.getText() + c); //押したボタンの名前をつなげる
        afterCalc=false;
        }
      }

   }
	else {
		result.setText(c); //押したボタンの文字列だけを設定する（いったんクリアしたかに見える）
		afterCalc = false;
	}
}

/* 数字を入力するボタンの定義 */
public class NumberButton extends JButton implements ActionListener {
   private static final long serialVersionUID = 1L;

   public NumberButton(String keyTop) {
      super(keyTop); //JButtonクラスのコンストラクタを呼び出す
      this.addActionListener(this); //このボタンにアクションイベントのリスナを設定
   }

   public void actionPerformed(ActionEvent evt) {
      String keyNumber = this.getText(); //ボタンの名前を取り出す
      appendResult(keyNumber); //ボタンの名前をテキストフィールドにつなげる
   }
}

/* 演算子ボタンを定義 */
public class CalcButton extends JButton implements ActionListener {
   private static final long serialVersionUID = 1L;

   public CalcButton(String op) {
      super(op);
      this.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e) {
      if (isStacked) { //以前に演算子ボタンが押されたのなら計算結果を出す
         double resultValue = (Double.valueOf(result.getText()))
               .doubleValue();
         if (currentOp.equals("+")) {//演算子に応じて計算する
            result.setText("");
            stackedValue += resultValue;
         }
         else if (currentOp.equals("-"))
            stackedValue -= resultValue;
         else if (currentOp.equals("x"))
            stackedValue *= resultValue;
         else if (currentOp.equals("÷")){
            stackedValue /= resultValue;
         }
         if(currentOp.equals("÷") && resultValue==0)
           result.setText("エラー");
         else{
         result.setText(String.valueOf(stackedValue)); //計算結果をテキストフィールドに設定
         }
      }
      currentOp = this.getText(); //ボタン名から押されたボタンの演算子を取り出す
      stackedValue = (Double.valueOf(result.getText())).doubleValue();
      afterCalc = true;
      if (currentOp.equals("="))
         isStacked = false;
      else
         isStacked = true;
   }
}

/* クリアボタンの定義 */
public class ClearButton extends JButton implements ActionListener {

   private static final long serialVersionUID = 1L;

   public ClearButton() {
      super("de");
      this.addActionListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
      stackedValue = 0.0;
      afterCalc = false;
      isStacked = false;
      result.setText("0");
   }

}
}
   
  

