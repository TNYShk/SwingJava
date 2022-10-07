package java_gui;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyJLabel {
    //JLabel =  a GUI display are for a string of text, an image, or both

    public static void main(String[] args) throws IOException {
        Path currentRelativePath = Paths.get("");

        JLabel label = new JLabel(); // create a label
        ImageIcon image = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/image/imageJL.jpeg")); // create an image or icon
        ImageIcon logo = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/image/fractal_logo.png")); // create an image or icon

        Border border = BorderFactory.createLineBorder(Color.WHITE,10); // create a border, set color and thickness
        /*
        //another way to import image
        BufferedImage img = ImageIO.read(new File(currentRelativePath.toAbsolutePath().toString().concat("/image/fractal_logo.png")));
        ImageIcon another = new ImageIcon(img);*/

        //label.setIcon(new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/image/imageJL.jpeg")));

        label.setText("Learning about JLabel"); // set text of label

        label.setIcon(logo); //set imageIcon of label

        label.setHorizontalAlignment(JLabel.CENTER); // set the horizontal position of (text and icon) within label
        //label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageIcon
        label.setVerticalTextPosition(JLabel.TOP); // set text TOP,CENTER, BOTTOM of image icon

        label.setBounds(100,100,250,250); //set x,y position of label within frame

        label.setForeground(Color.WHITE); //set font color of text
        label.setFont(new Font("Bradley Hand",Font.PLAIN,20)); //set Font of text
        label.setIconTextGap(20); //set gap of text to image
        label.setBorder(border);

        label.setBackground(new Color(0, 0, 250)); //set color of label
        label.setOpaque(true); //goes with setBackground, otherwise wont work

        MyFrame frame = new MyFrame(500,500,"JLabel class");
        //frame.getContentPane().setBackground(new Color(0, 0, 250)); // set color of entire frame

        frame.setLayout(null);
        frame.getContentPane().add(label);
        //frame.pack(); //resize the content of the frame, packs everything





    }


}
