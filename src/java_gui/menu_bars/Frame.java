package java_gui.menu_bars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
    JColorChooser - GUI mechanism that allows user to choose a color
    JFileChooser - GUI mechanism that allows user to choose a file (to open and save)
    JMenuBar - create an upper menu bar with items, keyboard shortcuts and item icons

 */
public class Frame extends JFrame implements ActionListener {
    private JButton button;
    private JMenuBar menuBar;
    private JMenu fileMenu ;
    private JMenu editMenu ;
    private JMenu helpMenu;
    private JMenuItem loadItem ;
    private JMenuItem saveItem ;
    private JMenuItem exitItem;

    private ImageIcon loadIcon;
    private ImageIcon saveIcon;
    private ImageIcon exitIcon;

    public Frame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MenuBar lesson");
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        button = new JButton("Select File");

        this.button.addActionListener(e -> {
            System.out.println("Foo"); // on each button click, CLI print
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(".")); // set the default location for JFileChooser for the project folder
            int response = fileChooser.showOpenDialog(null); //select a file to open, return int response
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }


        });
        Path currentRelativePath = Paths.get("");
        loadIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/src/java_gui/menu_bars/icons_iron-man.png"));
        saveIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/src/java_gui/menu_bars/icons_mario.png"));
        exitIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/src/java_gui/menu_bars/icons_anonymous.png"));
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        //add keys shortcut for the operations
        fileMenu.setMnemonic(KeyEvent.VK_F); // alt+ f to load
        editMenu.setMnemonic(KeyEvent.VK_E); // alt+ e to edit
        helpMenu.setMnemonic(KeyEvent.VK_H); // alt+ h to help

        loadItem.setMnemonic(KeyEvent.VK_L); // L for load
        saveItem.setMnemonic(KeyEvent.VK_S); // S for save
        exitItem.setMnemonic(KeyEvent.VK_E); // E for exit

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        loadItem.setIcon(loadIcon);
        saveItem.setIcon(saveIcon);
        exitItem.setIcon(exitIcon);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.add(button);
        this.setJMenuBar(menuBar);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loadItem)
            System.out.println("beep = " + loadItem.getText());
        if(e.getSource() == saveItem)
            System.out.println("beep = " + saveItem.getText());
        if(e.getSource() == exitItem) {
            System.out.println("GoodBye! = " + saveItem.getText());
            System.exit(0);
        }
    }
}
