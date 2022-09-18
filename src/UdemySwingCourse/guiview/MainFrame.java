package UdemySwingCourse.guiview;

import javax.swing.*;
import java.awt.*;

//Controller class(MVC)
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

        formPanel.setFormListener(new FormListener(){
            public void formEventOccured(FormEvent e){
                String name = e.getName();
                String job = e.getOccupation();
                int age = e.getAgeCategory();

                textPanel.appendText(name+": "+ job + " -> "+ age+ "\n");
            }
        });

        add(toolbar,BorderLayout.NORTH);
        add(formPanel,BorderLayout.WEST);
        add(textPanel,BorderLayout.CENTER);



        setSize(420,420);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
