package UdemySwingCourse.guiview;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel implements TextEraser{
    private JLabel nameLabel;
    private JLabel anotherLabel;
    private JTextField nameField;
    private JTextField anotherField;
    private JButton confirmButton;
    private FormListener formListener;
    private JList<String> ageList;

    private ButtonGroup group;
    private JRadioButton[] races = {new JRadioButton("Droid"),new JRadioButton("Elf"),new JRadioButton("Dwarf"),new JRadioButton("Human")};



    public enum ageCat {
        CHILD("Under 18"),ADULT("18-65"),OLD("Above 65");

        ageCat(String s) {
            this.s = s;
        }
        private final String s;

        public String getValue(){
            return s;
        }
        public int getIndex(){
            return this.ordinal();
        }
    }

//View component (MVC)
    public FormPanel(){
        Dimension fpd = getPreferredSize();
        System.out.println(fpd);
        fpd.width = 210;
        setPreferredSize(fpd);
        nameLabel = new JLabel("Name: ");
        anotherLabel = new JLabel("Title: ");
        nameField = new JTextField(10);
        anotherField = new JTextField(10);
        ageList = new JList<>();
        DefaultListModel<String> ageModel = new DefaultListModel<>();
        for(ageCat a: ageCat.values()){
            ageModel.addElement(a.getValue());
        }
       /* ageModel.addElement("Under 18");
        ageModel.addElement("18-65");
        ageModel.addElement("Above 65");*/
        ageList.setModel(ageModel);
        ageList.setFont(new Font("Futura",Font.PLAIN,13));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

        races[0].setActionCommand("Droid");
        races[1].setActionCommand("Elf");
        races[2].setActionCommand("Dwarf");
        races[3].setActionCommand("Human");

        group = new ButtonGroup();

        for(JRadioButton jb: races){
            group.add(jb);
        }
        races[races.length-1].setSelected(true);




        confirmButton = new JButton("OK");

        confirmButton.addActionListener(e -> {
            String name = nameField.getText();
            String job  = anotherField.getText();
            int ageCat = ageList.getSelectedIndex();
            System.out.println(ageList.getModel().getElementAt(ageCat));

            String race = group.getSelection().getActionCommand();
            System.out.println(race);
            FormEvent ev = new FormEvent(this,name,job,ageCat,race);


            if(formListener != null){
                formListener.formEventOccured(ev);
                cleanText();
                races[races.length-1].setSelected(true);
            }
        });

       /* add(nameLabel);
        add(nameField);
        add(anotherLabel);
        add(anotherField);
        add(confirmButton,BorderLayout.PAGE_END);*/
        Border innerBorder = BorderFactory.createTitledBorder("Add here");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        /* FIRST ROW */

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(nameLabel,gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameField,gc);

        /* SECOND ROW */
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridy = 1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(anotherLabel,gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(anotherField,gc);

        /* THIRD ROW */

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridy = 2;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Age: "),gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,5,0,0);
        add(ageList,gc);

        /* NEXT ROW */


        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Race: "),gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        for(JRadioButton db: races) {
            add(db, gc);
            gc.gridy++;
        }
        /* Last ROW */

        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridy++;
        gc.gridx = 1;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(confirmButton,gc);


    }
    @Override
    public void cleanText() {
        nameField.selectAll();

        nameField.replaceSelection("");
        anotherField.selectAll();
        anotherField.replaceSelection("");
    }

    public void setFormListener(FormListener e){
        formListener = e;}
}
