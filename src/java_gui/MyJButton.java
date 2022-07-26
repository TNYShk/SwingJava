package java_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJButton {
    //JButton = a button that performs an action when clicked...
    private JButton button = new JButton();
    private JLabel label;


    public MyJButton() {
        ImageIcon buttonImg = new ImageIcon("/Users/tanyashkolnik/IdeaProjects/SwingJava/src/classical_apple.png");
        ImageIcon labelImg = new ImageIcon("/Users/tanyashkolnik/IdeaProjects/SwingJava/src/psyduck.jpeg");

        label = new JLabel();
        label.setIcon(labelImg);
        label.setBounds(200,150,150,150);
        label.setVisible(false);

        this.button.setText("I'm a button!");
        this.button.setBounds(150,100,200,160);
        this.button.setFocusable(false); // when false removes "glow" around button
        this.button.setIcon(buttonImg);
        this.button.setHorizontalTextPosition(JButton.CENTER);
        this.button.setVerticalTextPosition(JButton.BOTTOM);
        //this.button.setBorder(BorderFactory.createEtchedBorder());


        //this.button.addActionListener(e -> System.out.println("Foo"));

        this.button.addActionListener(e -> {
                System.out.println("Foo");
                //button.setEnabled(false); //disable button after click!
            label.setVisible(true);
        });
    }




    public static void main(String[] args){

        MyFrame frame = new MyFrame(500,500,"JButton lesson");
        MyJButton but = new MyJButton();
        frame.getContentPane().add(but.button);
        frame.getContentPane().add(but.label);


    }
}