package UdemySwingCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton helloButton;
    private JButton byeButton;
    private JButton cleanButton;
    private StringListener textListener;
    private TextEraser eraser;

    public Toolbar(){
        setBorder(BorderFactory.createEtchedBorder());
        helloButton = new JButton("Hello");
        byeButton = new JButton("Bye");
        cleanButton = new JButton("clean");

        helloButton.addActionListener(this);
        byeButton.addActionListener(this);
        cleanButton.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEADING));

        add(helloButton);
        add(byeButton);
        add(cleanButton);
    }
    public void setStringListener(StringListener listener){
        this.textListener = listener;
    }
    public void setTextEraser(TextEraser listen){
        this.eraser = listen;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(textListener != null){
            if(e.getSource() == helloButton){
                textListener.textEmitted("Hello\n");
            }
            if(e.getSource() == byeButton){
                textListener.textEmitted("Bye\n");
            }
            if(e.getSource() == cleanButton){
                eraser.cleanText();
            }
        }
    }
}
