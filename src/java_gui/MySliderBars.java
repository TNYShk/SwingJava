package java_gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/*


    SliderBar - Visual aid to notify the user about a processing operation
 */
public class MySliderBars {

    private MyFrame frame;
    private JProgressBar bar;

    public MySliderBars() throws InterruptedException {

        bar = new JProgressBar();
        bar.setValue(0);
        bar.setBounds(0,0,420,50);
        bar.setStringPainted(true);
        bar.setFont(new Font("Milano", Font.ITALIC,25));
        bar.setForeground(Color.RED); //doesnt work on mac?
        bar.setBackground(Color.BLACK); //doesnt work on mac?

        frame = new MyFrame(420,200,"Progress Bar lesson");
        frame.add(bar);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();

    }
public void fill() throws InterruptedException {
        int counter = 0;

        while(counter++ <= 100){
            bar.setValue(counter);
            Thread.sleep(50);
        }
        bar.setString("Done!");

}

    static class SliderDemo implements ChangeListener {
        /*
    JSlider - GUI component that enables user to enter a value,
    by using an adjustable sliding knob on a track

    SliderBar - Visual aid to notify the user about a processing operation
 */
        private JFrame frame;
        private JPanel panel;
        private JLabel label;
        private JSlider slider;
        public SliderDemo(){
            frame = new JFrame("Slider Demo");
            panel = new JPanel();
            label = new JLabel();
            slider = new JSlider(0,100,50);

            slider.setPreferredSize(new Dimension(400,200));

            slider.setPaintTicks(true);
            slider.setMinorTickSpacing(10);

           // slider.setPaintTrack(true);

            slider.setMajorTickSpacing(50);

            slider.setPaintLabels(true);
            slider.setFont(new Font("Monaco",Font.PLAIN,15));
            label.setFont(new Font("Monaco",Font.PLAIN,30));
            slider.setOrientation(SwingConstants.VERTICAL);

            label.setText("ºC = "+ slider.getValue());
            slider.addChangeListener(this);
            panel.add(slider);
            panel.add(label);

            frame.add(panel);
            frame.setSize(420,420);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }

        @Override
        public void stateChanged(ChangeEvent e) {
            label.setText("ºC = "+ slider.getValue());

        }
    }


    public static void main(String[] args) throws InterruptedException {
        //new SliderDemo();
        new MySliderBars();



    }
}
