package java_gui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {


    public MyFrame(){
        this(420,420,"JFrame title here");
    }
    public MyFrame(int width, int height, String frame_title){
        this.setTitle(frame_title); // sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        //this.setResizable(false); //prevent frame from being resized
        this.setSize(width,height); // sets the x and y dimension of the frame
        this.setVisible(true); // make frame visible
        //this.getContentPane().setBackground(new Color(123,50,150)); // change color of background, can also use hexadecimal instead
        //this.pack() //minimizes size to pack everything tightly
    }
    public MyFrame(int width, int height){
       this(width,height,"JFrame title here");
    }
}
