package UdemySwingCourse.guiview;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private JTextArea textArea;

    public TextPanel(){
        textArea = new JTextArea();
        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void appendText(String text){
        textArea.append(text);
    }

    public void cleanText(){
        //textArea.setText(null);
        textArea.selectAll();
        textArea.replaceSelection("");

    }




}
