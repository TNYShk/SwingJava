package java_gui;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MyJButton {
    //JButton = a button that performs an action when clicked...
    private JButton button;
    private JLabel label;


    public MyJButton() {
        Path currentRelativePath = Paths.get("");

        ImageIcon buttonImg = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/src/classical_apple.png"));
        ImageIcon labelImg = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/src/psyduck.png"));
        button = new JButton();
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
        //this.button.setBorder(BorderFactory.createEtchedBorder()); //looks a bit 3d


        //this.button.addActionListener(e -> System.out.println("Foo"));

        this.button.addActionListener(e -> {
                System.out.println("Foo"); // on each button click, CLI print
                //button.setEnabled(false); //disable button after click!
            label.setVisible(true);
            button.setVisible(false);
        });
    }




    public static void main(String[] args){

        MyFrame frame = new MyFrame(500,500,"JButton lesson");
        MyJButton but = new MyJButton();
        frame.getContentPane().add(but.button);
        frame.getContentPane().add(but.label);
        frame.setVisible(true);

    }
}
