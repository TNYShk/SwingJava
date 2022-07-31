package java_gui;



import javax.swing.*;

public class MyJOptionPane {
/*
    some of the following dialog icons appear on a Mac
 */
    public static void main(String[] args){
        ImageIcon iconTest = new ImageIcon("/Users/tanyashkolnik/IdeaProjects/SwingJava/src/fractal.png"); // create an image or icon
//message dialog: plain, information,question,warning,error
        JOptionPane.showMessageDialog(null,"This appears in msg dialog","msg dialog title",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"This appears in info msg \n it has an icon","msg dialog title",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"This appears in question dialog","msg dialog title",JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null,"This appears in warning msg ","Virus Alert",JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null,"This appears in error msg dialog","error message title",JOptionPane.ERROR_MESSAGE);

//conformation dialog
        JOptionPane.showConfirmDialog(null,"Are you using Mac OS?", "confirmation dialog title",JOptionPane.YES_NO_OPTION);
        //System.out.println( JOptionPane.showConfirmDialog(null,"Are you using Mac OS?", "confirmation dialog title",JOptionPane.YES_NO_CANCEL_OPTION));
        int answer = JOptionPane.showConfirmDialog(null,"Are you using Mac OS?", "confirmation dialog title",JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println(answer);
 //input dialog
        String input = JOptionPane.showInputDialog("what is your name?");
        System.out.println(input);

//show option dialog, combo of all
        String[] responseButton = {"*blush*","No, you're awesome","Thanks!"};
        JOptionPane.showOptionDialog(null,"you are awesome ","secret msg title",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,iconTest,responseButton,1);

    }
}
