package UdemySwingCourse.guiview;

import javax.swing.*;
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

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        //first row

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;

        add(new JLabel("User: "), gc);

        gc.gridx++;
        add(userField,gc);


        // next row
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;

        add(new JLabel("Password: "), gc);

        gc.gridx++;
        add(passField,gc);

        // next row
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;

        add(new JLabel("Port: "), gc);

        gc.gridx++;
        add(portSpinner,gc);


        // next row
        gc.gridy++;

        gc.gridx = 0;
        add(okBut,gc);

        gc.gridx++;
        add(cancelBut,gc);

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

        setSize(400,300);
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
}
