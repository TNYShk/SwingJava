package UdemySwingCourse.guiview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton saveButton;
    private JButton refreshButton;
    private JButton cleanButton;
    private ToolbarListener textListener;
    private FormPanelCleaner eraser;

    public Toolbar(){
        setBorder(BorderFactory.createEtchedBorder());
        saveButton = new JButton("Save");
        refreshButton = new JButton("Refresh");
        cleanButton = new JButton("Clean");

        saveButton.addActionListener(this);
        refreshButton.addActionListener(this);
        cleanButton.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEADING));

        add(cleanButton);
        add(saveButton);
        add(refreshButton);

    }
    public void setToolbarListener(ToolbarListener listener){
        this.textListener = listener;
    }
    public void setTextEraser(FormPanelCleaner listen){
        this.eraser = listen;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(textListener != null){
            if(e.getSource() == saveButton){
                textListener.saveEventHappened();
            }
            if(e.getSource() == refreshButton){
                textListener.refreshEventHappened();
            }
            if(e.getSource() == cleanButton){
                eraser.cleanText();

            }
        }
    }
}
