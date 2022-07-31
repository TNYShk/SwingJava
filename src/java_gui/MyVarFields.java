package java_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
    including:
    textField - a GUI textbox component used to add. set, get text input
    JCheckBox -  a GUI component that can be selected ir deselected
    JRadioButton - one or more buttons in a grouping, single choice (only one selected)

 */
public class MyVarFields implements ActionListener {

    private final MyFrame frame;
    private JTextField  textField;
    private JLabel nameLabel;
    private JButton button;
    private JCheckBox checkBox;

    private ButtonGroup group;
    private JRadioButton[] options = {new JRadioButton("Droid"), new JRadioButton("Elf"), new JRadioButton("Dwarf"), new JRadioButton()};


    public MyVarFields(){
        Path currentRelativePath = Paths.get("");

        ImageIcon icon = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/src/psyduck.png"));
        ImageIcon icon1 = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/src/jigglypuff.png"));
        frame = new MyFrame(420,420,"TextField lesson");
        frame.setLayout(new FlowLayout());

        nameLabel = new JLabel("enter your name: ");
        textField = new JTextField();

        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("American Typewriter",Font.PLAIN, 25));
        textField.setForeground(new Color(0x00FF00));
        textField.setText("......"); //set a default text inside

        button = new JButton("Submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("im not a robot");
        checkBox.setVerticalAlignment(JCheckBox.BOTTOM);



      /*
      //setting icons instead of regular checkbox
        ImageIcon veIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/src/green.png")); // create an image or icon
        ImageIcon xIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString().concat("/src/redx.png")); // create an image or icon
        checkBox.setIcon(xIcon); //unchecked
        checkBox.setSelectedIcon(veIcon); //checked
        */
        group = new ButtonGroup();
        for(JRadioButton jb: options){
          group.add(jb);
        }


        options[0].addActionListener(e->{
            textField.setText("You're a Droid!");
            System.out.println("welcome "+options[0].getText() );
        });
        options[1].addActionListener(e->{
            textField.setText("You're an Elf!");
            textField.setEditable(true);
            button.setEnabled(true); // disable button
            checkBox.setEnabled(true); //disable checkbox
            System.out.println("welcome "+options[1].getText() );
            //options[2].setIcon(icon1);

        });
        options[2].addActionListener(e->{
            textField.setText("You're a Dwarf!");
            System.out.println("welcome "+options[2].getText() );
        });
        options[3].addActionListener(e->{
            textField.setText("PSY??");
            options[3].setIcon(icon);
        });




        frame.add(nameLabel);
        frame.add(textField);
        frame.add(checkBox);
        frame.add(button);

        //frame.setVisible(true);


        frame.pack();

    }

    public static void main(String[] args){
        new MyVarFields();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            if(checkBox.isSelected()) {
                System.out.println("Welcome " + textField.getText());

                for(JRadioButton jb: options){
                    jb.setEnabled(false);
                }

            }else {
                textField.setText("You're a Bot!");
                textField.setEditable(false); // can't change text field

                frame.add(options[0]);
                frame.add(options[1]);
                frame.add(options[2]);
                frame.add(options[3]);
            }
            checkBox.setEnabled(false); //disable checkbox
            button.setEnabled(false); // disable button


        }

    }
}
