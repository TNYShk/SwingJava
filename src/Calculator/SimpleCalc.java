package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalc {
    private JPanel MainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JTextField textField1;
    private JButton ADDButton;
    private JButton MODButton;
    private JButton MULTPLYButton;
    private JButton CLEARButton;
    private JTextField txtfield2;
    private JTextField resfield3;

    public SimpleCalc() {
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = textField1.getText().trim();
                String num2 =  txtfield2.getText().trim();

                double parsedNum = 0;
                double parsedNum2 = 0;
                double result;
                try{
                    parsedNum = Double.parseDouble(num1);
                    parsedNum2 = Double.parseDouble(num2);
                }catch(NumberFormatException | NullPointerException err){
                    System.err.println("Not Valid");
                }

                result = parsedNum2 + parsedNum;
                resfield3.setText(result+"");
            }
        });
        MULTPLYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = textField1.getText().trim();
                String num2 =  txtfield2.getText().trim();

                double parsedNum = 0;
                double parsedNum2 = 0;
                double result;
                try{
                    parsedNum = Double.parseDouble(num1);
                    parsedNum2 = Double.parseDouble(num2);
                }catch(NumberFormatException | NullPointerException err){
                    System.err.println("Not Valid");
                }finally {
                    result = parsedNum2 * parsedNum;
                }
                resfield3.setText(result+"");
            }
        });
        MODButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = textField1.getText().trim();
                String num2 =  txtfield2.getText().trim();
                double result = Double.parseDouble(num1) % Double.parseDouble(num2);
                resfield3.setText(result+"");
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                txtfield2.setText("");
                resfield3.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TanyaSampleCalculator");
        frame.setContentPane(new SimpleCalc().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
