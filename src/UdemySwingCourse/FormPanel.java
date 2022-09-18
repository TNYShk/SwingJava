package UdemySwingCourse;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel{
    private JLabel nameLabel;
    private JLabel anotherLabel;
    private JTextField nameField;
    private JTextField anotherField;
    private JButton confirmButton;


    public FormPanel(){
        Dimension fpd = getPreferredSize();
        System.out.println(fpd);
        fpd.width = 210;
        setPreferredSize(fpd);
        nameLabel = new JLabel("Name: ");
        anotherLabel = new JLabel("Job: ");
        nameField = new JTextField(10);
        anotherField = new JTextField(10);
        confirmButton = new JButton("OK");

        add(nameLabel);
        add(nameField);
        add(anotherLabel);
        add(anotherField);
        add(confirmButton,BorderLayout.SOUTH);
        Border innerBorder = BorderFactory.createTitledBorder("Add here");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

      /*  setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel,gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField,gc);

        gc.gridy = 1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(anotherLabel,gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(anotherField,gc);

        gc.gridy = 2;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(confirmButton,gc);*/





    }
}
