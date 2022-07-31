package java_gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
    Layout Manager - defines the natural layout for components within a container

    3 common managers:
    Border, Grid, Flow

    JLayeredPane - Swing Container that provides 3rd dimension for component positioning
    for example depth- Z index
 */

public class MyLayoutManager {

    public static void main(String[] args) throws IOException {
        borderLayout();
        //gridLayout();
        //flowLayout();
        //JLayerPane();
    }

    public static void JLayerPane(){

        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setBounds(50,50,200,200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.GREEN);
        label2.setBounds(100,100,200,200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.BLUE);
        label3.setBounds(150,150,200,200);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,500);

        //specify to which layer add the component to, either number
        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(2));
        // OR specify the desired layer by name:
        //layeredPane.add(label2, JLayeredPane.MODAL_LAYER);
        layeredPane.add(label3,Integer.valueOf(1));


        MyFrame layerFrame = new MyFrame(500,500,"JLayeredPane Lesson");
        layerFrame.add(layeredPane);
        layerFrame.setLayout(null);

    }


    public static void borderLayout() throws IOException {
        /*
         BorderLayout - a BorderLayout places components in five areas: NORTH, SOUTH, WEST, EAST, CENTER.
                     all extra space is placed in the center area
         */
        Path currentRelativePath = Paths.get("");

        MyFrame frameBorder = new MyFrame(710,710,"BorderLayout Lesson");
        frameBorder.setLayout(new BorderLayout(10,10)); //hgap, vgap- sdd margins between panels
        BufferedImage myPicture = ImageIO.read(new File(currentRelativePath.toAbsolutePath().toString().concat("/src/054.png")));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(Color.RED);
        panel2.setBackground(Color.GREEN);
        panel3.setBackground(Color.YELLOW);
        panel4.setBackground(Color.MAGENTA);
        panel5.setBackground(Color.BLUE);

        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));


        //---------------sub panels-----------------------
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();

        panel6.setBackground(Color.BLACK);
        panel7.setBackground(Color.DARK_GRAY);
        panel8.setBackground(Color.GRAY);
        panel9.setBackground(Color.LIGHT_GRAY);
        panel10.setBackground(Color.WHITE);

        panel5.setLayout(new BorderLayout());
        panel10.setLayout(new FlowLayout());
        panel10.add(picLabel);

        panel6.setPreferredSize(new Dimension(50,50));
        panel7.setPreferredSize(new Dimension(50,50));
        panel8.setPreferredSize(new Dimension(50,50));
        panel9.setPreferredSize(new Dimension(50,50));
        panel10.setPreferredSize(new Dimension(50,50));

        panel5.add(panel6,BorderLayout.NORTH);
        panel5.add(panel7,BorderLayout.SOUTH);
        panel5.add(panel8,BorderLayout.WEST);
        panel5.add(panel9,BorderLayout.EAST);
        panel5.add(panel10,BorderLayout.CENTER);
        //------------------ sub panels---------------------------

        frameBorder.add(panel1,BorderLayout.NORTH);
        frameBorder.add(panel2,BorderLayout.WEST);
        frameBorder.add(panel3,BorderLayout.EAST);
        frameBorder.add(panel4,BorderLayout.SOUTH);
        frameBorder.add(panel5,BorderLayout.CENTER);

    }

    public static void gridLayout(){
        /*
            GridLayout - places components in a grid of cells.
            Each component takes all the available space within its cell, and each cell is the same size
        */

        MyFrame frame = new MyFrame(500,500,"GridLayout Lesson");

        frame.setLayout(new GridLayout(3,3,5,5)); //Ctor(rows,columns,OPTIONAL: horizontal gap btwm, vertical gap btwn)
        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));


        frame.setVisible(true);
    }
    public static void flowLayout(){
        /*
            FlowLayout - places components in a row, sized at their preferred size.
            If the horizontal space in the container is too small, the FlowLayout class uses the next available row.
         */
        MyFrame frameFlow = new MyFrame(500,500,"FlowLayout Lesson");
        frameFlow.setLayout(new FlowLayout());
        //frame.setLayout(new FlowLayout(FlowLayout.CENTER)); /*FlowLayout.LEADING, FlowLayout.TRAILING changes the components position in the flow */
        //frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10)); // change vertical and horizontal spacing between components

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(415,250));
        panel.setBackground(Color.PINK);
        //panel.setLayout(new FlowLayout()); /* flow is the default for panel*/

        panel.add(new JButton("T"));
        panel.add(new JButton("A"));
        panel.add(new JButton("N"));
        panel.add(new JButton("Y"));
        panel.add(new JButton("a"));

        panel.add(new JButton("F"));
        panel.add(new JButton("L"));
        panel.add(new JButton("O"));
        panel.add(new JButton("W"));
        panel.add(new JButton("LAYOUT"));

        frameFlow.add(panel);


        frameFlow.setVisible(true);
    }


}
