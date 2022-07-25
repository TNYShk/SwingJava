package java_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJButton {
    //JButton = a button that performs an action when clicked...
    private JButton button = new JButton();

    public MyJButton() {
        this.button.setText("I'm a button!");
        this.button.setBounds(200,200,100,50);
        this.button.setFocusable(false); // when false removes "glow" around button
        this.button.addActionListener(e -> System.out.println("Foo"));

    }



    public static void main(String[] args){

        MyFrame frame = new MyFrame(500,500,"JButton lesson");

        frame.getContentPane().add(new MyJButton().button);

        //frame.setVisible(true);

    }
}
