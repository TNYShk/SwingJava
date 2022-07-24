package Calculator;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PrettyCalc implements ActionListener{
    private JFrame frame;
    private JTextField textField;
    private JTextField logField;
    private JButton addButton, subButton, multiButton, divButton;
    private JButton decButton, eqButton, delButton, clrButton, negButton;
    private JButton modButton, powButton;
    private JPanel panel;
    private Font myFont = new Font("Menlo",Font.BOLD, 30);
    private Font logFont = new Font("Menlo",Font.PLAIN, 16);

    //private JButton[] operButtons = new JButton[10];
    private JButton[] operators = {
            addButton = new JButton("+"), subButton = new JButton("-"),
            multiButton = new JButton("*"), divButton = new JButton("/"),
            //modButton = new JButton("%"), powButton= new JButton("^"),
            decButton = new JButton("."), eqButton = new JButton("="),
            delButton = new JButton("DEL"), clrButton = new JButton("CLR"),
            negButton = new JButton("(-)")
    };

    private JButton[] numButtons = new JButton[10];
    private double num1 = 0.0;
    private double num2 = 0.0;
    private char operator = ' ';

    public PrettyCalc() {
        frame = new JFrame("My Calc U Later");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        logField = new JTextField();
        logField.setBounds(50,70,300,30);
        logField.setFont(logFont);
        logField.setBackground(Color.LIGHT_GRAY);
        logField.setEditable(false);

        for (int i = 0; i < 9; ++i){
            operators[i].addActionListener(this);
            operators[i].setFont(myFont);
            operators[i].setFocusable(false);
        }
        for (int i = 0; i < 10;++i){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(multiButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

    clrButton.addActionListener(e -> {
        textField.setText("");
        logField.setText("");
    });
        delButton.addActionListener(e -> {
            int logLen = logField.getText().length();
            int txtLen = textField.getText().length();

            try {
                logField.setText(logField.getText(0,logLen-1));
                textField.setText(textField.getText(0,txtLen-1));

            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        });


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.add(logField);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        PrettyCalc calc = new PrettyCalc();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i< 10; ++i){
            if(e.getSource() == numButtons[i]){
                textField.setText(textField.getText().concat(numButtons[i].getText()));
                logField.setText(logField.getText().concat(numButtons[i].getText()));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat(decButton.getText()));
            logField.setText(logField.getText().concat(decButton.getText()));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText().trim());
            operator = '+';
            logField.setText(logField.getText().concat(" + "));
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText().trim());
            operator = '-';
            logField.setText(logField.getText().concat(" - "));
            textField.setText("");
        }
        if(e.getSource() == multiButton){
            num1 = Double.parseDouble(textField.getText().trim());
            operator = '*';
            logField.setText(logField.getText().concat(" * "));
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText().trim());
            operator = '/';
            logField.setText(logField.getText().concat(" / "));
            textField.setText("");
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText().trim());
            int logLen = logField.getText().length();

            temp *= -1;
            textField.setText(String.valueOf(temp));
            if(logLen > 1){
                String end = logField.getText().substring(logLen -1);
                String start = logField.getText().substring(0,logLen -1);
                logField.setText(start.concat("(-").concat(end).concat(")"));
            }else{
                logField.setText("-"+logField.getText());
            }

        }
        if(e.getSource() == eqButton){
            num2 = Double.parseDouble(textField.getText().trim());
            double result = 0;
            switch(operator){
                case('+'):
                   result = num1 + num2;
                   break;
                case('-'):
                    result = num1 - num2;
                    break;
                case('*'):
                    result = num1 * num2;
                    break;
                case('/'):
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            //logField.setText(logField.getText().concat(" = ").concat(String.valueOf(result)));

            num1 = result;

            logField.setText(String.valueOf(num1));
        }
    }

}
