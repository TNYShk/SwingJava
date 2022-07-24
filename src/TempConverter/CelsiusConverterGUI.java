package TempConverter;

import Calculator.SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusConverterGUI  {

    private JPanel mainPanel;
    private JTextField CelsiusTextField;
    private JButton ConvertButton;
    private JLabel farhenheitLabel;

    public CelsiusConverterGUI(){

        ConvertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // grab the text from the field
                //convert to double
                // update to fahrenheit
                double tempFahr = ((Double.parseDouble(CelsiusTextField.getText()))
                        * 1.8 + 32);
                farhenheitLabel.setText(tempFahr + " Fahrenheit");
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("My Temp Converter");
        frame.setContentPane(new CelsiusConverterGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
