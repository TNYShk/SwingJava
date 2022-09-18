package UdemySwingCourse;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private TextPanel textPanel;
    private Toolbar toolbar;
   private FormPanel formPanel;

    public MainFrame(){
        super("UdemySwing");

        setLayout(new BorderLayout());
        formPanel = new FormPanel();
        toolbar = new Toolbar();
        textPanel = new TextPanel();


        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        toolbar.setTextEraser(() -> textPanel.cleanText());

        add(toolbar,BorderLayout.NORTH);
        add(formPanel,BorderLayout.WEST);
        add(textPanel,BorderLayout.CENTER);



        setSize(420,420);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
