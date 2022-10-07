package java_gui.window_opener;

import java_gui.MyFrame;

import javax.swing.*;
import java.awt.*;

public class NewWindow {
    private MyFrame frame = new MyFrame(420,420,"New Window class");
    private JLabel label = new JLabel("Hello new window!");
    public NewWindow(){
        label.setBounds(0,0,100,50);
        label.setFont(new Font(null,Font.PLAIN,25));

        frame.add(label);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
