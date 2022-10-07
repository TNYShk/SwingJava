package UdemySwingCourse.guiview;

import UdemySwingCourse.controller.Controller;


import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class MainFrame extends JFrame {
    private TextPanel textPanel;
    private Toolbar toolbar;
   private FormPanel formPanel;
   private Controller controller;
   private TablePanel tablePanel;
   private JFileChooser fileChooser;


    public MainFrame(){
        super("UdemySwing");

        setLayout(new BorderLayout());
        formPanel = new FormPanel();
        toolbar = new Toolbar();
        textPanel = new TextPanel();
        tablePanel = new TablePanel();
        controller = new Controller();
        fileChooser = new JFileChooser();
        //adding desirable filters for file extenssions
        fileChooser.addChoosableFileFilter(new PersonFileFilter());

        setJMenuBar(createMenuBar());
        tablePanel.setData(controller.getPeople());
        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        toolbar.setTextEraser(() -> formPanel.cleanText());

        formPanel.setFormListener(new FormListener(){
            public void formEventOccured(FormEvent e){
               /* String name = e.getName();
                String job = e.getOccupation();
                int age = e.getAgeCategory();
                String race = e.getRace();

                textPanel.appendText(name+": "+ job + "-> " +race+ "\n");*/

                controller.addPerson(e);
                tablePanel.refresh();
            }
        });

        add(toolbar,BorderLayout.NORTH);
        add(formPanel,BorderLayout.WEST);
        //add(textPanel,BorderLayout.CENTER);
        add(tablePanel,BorderLayout.CENTER);



        setSize(600,420);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem loadFile = new JMenuItem("Import",KeyEvent.VK_I);
        JMenuItem saveFile = new JMenuItem("Export",KeyEvent.VK_E);
        JMenuItem exit = new JMenuItem("Exit",KeyEvent.VK_X);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        loadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){

                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });
        saveFile.addActionListener(e -> {
            if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                System.out.println(fileChooser.getSelectedFile());
            }
        });
        fileMenu.setMnemonic(KeyEvent.VK_F); // alt+ f to load
        exit.addActionListener(e -> System.exit(0));


        fileMenu.add(saveFile);
        fileMenu.add(loadFile);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        menuBar.add(fileMenu);

        return menuBar;

    }
}
