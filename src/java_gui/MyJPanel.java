package java_gui;



import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MyJPanel {
    //JPanel = a GUI component that functions as a container to hold other components, can add components to a panel and then add panel to a frame
    //its default layout is Flow

    public static void main(String[] args){
        Path currentRelativePath = Paths.get("");
        ImageIcon icon = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/image/054.png"));

        JLabel label = new JLabel();
        label.setText("Psyduck");
        label.setIcon(icon);
        label.setVerticalAlignment(JLabel.TOP);
        //label.setBounds(0,150,256,256); //manual setting of bounds
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Times",Font.BOLD,18));

        JLabel blues = new JLabel("feeling blue");
        blues.setVerticalTextPosition(JLabel.CENTER);
        blues.setHorizontalTextPosition(JLabel.CENTER);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0,0,250,250);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250,0,250,250);
        bluePanel.setLayout(new BorderLayout());

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0,250,500,250);

        greenPanel.setLayout(new BorderLayout()); // set the Panel layout to a border layout (like in the frames' layout)

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
