package UdemySwingCourse.guiview;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PrefsDialog extends JDialog {
    private JButton okBut;
    private JButton cancelBut;
    private JSpinner portSpinner;
    private SpinnerNumberModel spinnerModel;

    private JTextField userField;
    private JPasswordField passField;
    private PrefsListener prefsListener;
    public PrefsDialog(JFrame parent){
        super(parent,"Preferences",false);

        okBut = new JButton("OK");
        cancelBut = new JButton("Cancel");
    //default sql port: 3306
        spinnerModel = new SpinnerNumberModel(3306,0,9999,1);
        portSpinner = new JSpinner(spinnerModel);

        userField = new JTextField(10);
        passField = new JPasswordField(10);

        layoutControls();

        okBut.addActionListener(e->{
            //System.out.println(spinnerModel.getValue());
            String user = userField.getText();
            String pass = (String.valueOf(passField.getPassword()));
            //System.out.println(user+" "+pass.toString());

            if(prefsListener != null){
                prefsListener.preferencesSet(user,pass,(int)spinnerModel.getValue());
            }
            setVisible(false);
        });

        cancelBut.addActionListener(e-> setVisible(false));

        setSize(300,200);
        setLocationRelativeTo(parent);
    }

    public void setPrefsListener(PrefsListener prefsListener) {
        this.prefsListener = prefsListener;
    }

    public void setDefaults(String user, String pass, int port){
        userField.setText(user);
        passField.setText(pass);
        portSpinner.setValue(port);
    }

    private void layoutControls(){

        JPanel controlsPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        controlsPanel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));


        controlsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;

        Insets rightPadding = new Insets (0,0,0,15);
        Insets noPadding = new Insets (0,0,0,0);
        //first row

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        controlsPanel.add(new JLabel("User: "), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        controlsPanel.add(userField,gc);


        // next row
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        controlsPanel.add(new JLabel("Password: "), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        controlsPanel.add(passField,gc);

        // next row
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        controlsPanel.add(new JLabel("Port: "), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        controlsPanel.add(portSpinner,gc);


        // next row Buttons Panel
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        buttonsPanel.add(okBut);
        buttonsPanel.add(cancelBut);

        //add sublayout
        setLayout(new BorderLayout());
        add(controlsPanel,BorderLayout.CENTER);
        add(buttonsPanel,BorderLayout.SOUTH);
    }
}
