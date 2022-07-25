package java_gui;



import javax.swing.*;
import java.awt.*;


public class MyJPanel {
    //JPanel = a GUI component that functions as a container to hold other components

    public static void main(String[] args){


        ImageIcon icon = new ImageIcon("/Users/tanyashkolnik/IdeaProjects/SwingJava/src/054.png");

        JLabel label = new JLabel();
        label.setText("Psyduck");
        label.setIcon(icon);
        label.setBounds(0,150,256,256);
        label.setFont(new Font("Times",Font.BOLD,18));

        JLabel blues = new JLabel("feeling blue");

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0,0,250,250);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250,0,250,250);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0,250,500,250);

        MyFrame frame = new MyFrame(700,700,"JPanel Lesson");

        frame.setLayout(null);


        greenPanel.add(label);
        bluePanel.add(blues);

        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
        frame.setVisible(true);

    }

}
