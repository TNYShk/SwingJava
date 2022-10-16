package UdemySwingCourse.guiview;

import UdemySwingCourse.controller.Controller;


import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.prefs.Preferences;


public class MainFrame extends JFrame {
    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;
    private Controller controller;
    private TablePanel tablePanel;
    private JFileChooser fileChooser;
    private PrefsDialog prefsDialog;
    private final Preferences prefs;//storing small things onto OS memory, like user,pass. remains between runs of the app

    public MainFrame()  {
        super("UdemySwing");

        setLayout(new BorderLayout());
        formPanel = new FormPanel();
        toolbar = new Toolbar();
        textPanel = new TextPanel();
        tablePanel = new TablePanel();
        prefsDialog = new PrefsDialog(this);
        prefs = Preferences.userRoot().node("ts");
        controller = new Controller();

        tablePanel.setData(controller.getPeople());

        tablePanel.setPersonTableListener(new PersonTableListener(){
            @Override
            public void rowDeleted(int row) {
                System.out.println("MainFrame->rowDeleted "+row);
                controller.removePerson(row);
            }
        });


        prefsDialog.setPrefsListener(new PrefsListener() {
            @Override
            public void preferencesSet(String user, String password, int port) {
                System.out.println(user+" "+password+" "+ port);
                prefs.put("user", user);
                prefs.put("password", password);
                prefs.putInt("port", port);
            }
        });
        String user = prefs.get("user","");
        String password = prefs.get("password","");
        int port = prefs.getInt("port",3306);

        prefsDialog.setDefaults(user,password,port);


        fileChooser = new JFileChooser();
        //adding desirable filters for file extensions in file loader
        fileChooser.addChoosableFileFilter(new PersonFileFilter());

        setJMenuBar(createMenuBar());

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


        setMinimumSize(new Dimension(600,420));
        setSize(600,500);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                int result = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Exit Now?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else if (result == JOptionPane.NO_OPTION)
                   setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F); // alt+ f to file menue
        JMenu winMenu = new JMenu("Window");
        winMenu.setMnemonic(KeyEvent.VK_W); // alt+ w to window menu
        JMenu showMenu = new JMenu("Show");
        JMenuItem prefWinItem = new JMenuItem("Preferences...");

        showMenu.add(prefWinItem);
        winMenu.add(showMenu);

        JMenuItem loadFile = new JMenuItem("Import",KeyEvent.VK_I);
        JMenuItem saveFile = new JMenuItem("Export",KeyEvent.VK_E);
        JMenuItem exit = new JMenuItem("Exit",KeyEvent.VK_X);

        prefWinItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
        loadFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,KeyEvent.CTRL_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_MASK));

        loadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        tablePanel.refresh(); //otherwise panel wont recognize new data
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this,"Failed to load data from file", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                    //System.out.println(fileChooser.getSelectedFile());
                }
            }
        });
        saveFile.addActionListener(e -> {
            if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                //System.out.println(fileChooser.getSelectedFile());
                try {
                    controller.saveToFile(fileChooser.getSelectedFile());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,"Failed to save data to file", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        exit.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  int selection = JOptionPane.showConfirmDialog(MainFrame.this, "Are You Sure??", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

                  if(selection == JOptionPane.OK_OPTION)
                        System.exit(0);
               }
        });

        prefWinItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prefsDialog.setVisible(true);
            }
        });





        fileMenu.add(saveFile);
        fileMenu.add(loadFile);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        menuBar.add(fileMenu);
        menuBar.add(winMenu);

        return menuBar;

    }
}
