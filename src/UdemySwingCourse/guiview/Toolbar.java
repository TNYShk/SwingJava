package UdemySwingCourse.guiview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton helloButton;
    private JButton byeButton;
    private JButton cleanButton;
    private StringListener textListener;
    private FormPanelCleaner eraser;

    public Toolbar(){
        setBorder(BorderFactory.createEtchedBorder());
        helloButton = new JButton("Hello");
        byeButton = new JButton("Bye");
        cleanButton = new JButton("Clean");

        helloButton.addActionListener(this);
        byeButton.addActionListener(this);
        cleanButton.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEADING));

        add(cleanButton);
        add(helloButton);
        add(byeButton);

    }
    public void setStringListener(StringListener listener){
        this.textListener = listener;
    }
    public void setTextEraser(FormPanelCleaner listen){
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
