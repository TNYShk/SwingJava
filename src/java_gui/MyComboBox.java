package java_gui;

import javax.swing.*;
import java.awt.*;

public class MyComboBox {
    private MyFrame frame;

    private JComboBox comboBox;
    private String[] animals = {"dog","cat","bird"};

    public MyComboBox(){
        frame = new MyFrame(500,500,"ComBox Lesson");
        comboBox = new JComboBox<>(animals);
        //comboBox.setEditable(true); //make it writable

        comboBox.addItem("horse");
        comboBox.insertItemAt("pig",0);
        System.out.println(comboBox.getItemCount()); //returns amount of items in it
        //comboBox.removeItem("horse"); //remove item by name
        //comboBox.removeItemAt(0); //remove item at index
        comboBox.removeAll();// remove all items in the combox
        System.out.println(comboBox.getItemCount()); //returns amount of items in it
        comboBox.setSelectedIndex(0); // default selection can be set to index
        frame.setLayout(new FlowLayout());
        frame.add(comboBox);
        frame.pack();
        frame.setVisible(true);

        comboBox.addActionListener(e-> System.out.println("Hi "+comboBox.getSelectedItem()));
    }
    public static void main(String[] args){
        new MyComboBox();
    }


}
