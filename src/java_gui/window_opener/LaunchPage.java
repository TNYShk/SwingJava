package java_gui.window_opener;

import java_gui.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {
    private MyFrame frame = new MyFrame(420,420,"LaunchPane lesson");
    private JButton myButton = new JButton("new window");

   public LaunchPage(){
       myButton.setBounds(100,160,200,40);
       myButton.setFocusable(false);
       myButton.addActionListener(this);

       frame.add(myButton);
        frame.setLayout(null);
        frame.setVisible(true);

   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == myButton){
            frame.dispose(); //close the frame upon clicking its button
            NewWindow myWindow = new NewWindow();
        }
    }
}
