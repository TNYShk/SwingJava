package java_gui;

import javax.swing.*;
import java.awt.*;

public class MyJPanel {
    //JPanel = a GUI component that functions as a container to hold other components

    public static void main(String[] args){


        ImageIcon image = new ImageIcon("/Users/tanyashkolnik/IdeaProjects/SwingJava/src/imageJL.jpeg");
        JLabel label = new JLabel();

        label.setText("Learning about Panels");
        label.setIcon(image);
        label.setBounds(100,100,700,700); //set x,y position of label within frame
        label.setFont(new Font("Bradley Hand",Font.PLAIN,20));
        label.setForeground(Color.BLACK);

       /* JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0,0,250,250);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250,0,250,250);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0,250,500,250);*/

        MyFrame frame = new MyFrame(750,750,"JPanel lesson");
        //frame.add(label);
        //frame.setLayout(null);
        frame.getContentPane().add(label);

        //redPanel.add(label);
        /*frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);*/


    }

}
