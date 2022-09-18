package UdemySwingCourse.guiview;

import UdemySwingCourse.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private TextPanel textPanel;
    private Toolbar toolbar;
   private FormPanel formPanel;
   private Controller controller;

    public MainFrame(){
        super("UdemySwing");

        setLayout(new BorderLayout());
        formPanel = new FormPanel();
        toolbar = new Toolbar();
        textPanel = new TextPanel();

        controller = new Controller();

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
                String race = e.getRace();

                textPanel.appendText(name+": "+ job + "-> " +race+ "\n");
                controller.addPerson(e);
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
