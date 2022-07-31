package snake_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class GamePanel extends JPanel implements ActionListener {

    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int UNIT_SIZE = 25; //size of the items in the game
    private static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/ UNIT_SIZE;
    private static final int DELAY = 75; // the higher the number the slower the game

    private final int[] x = new int[GAME_UNITS]; // array to hold x coordinates for the snakes' body parts
    private final int[] y = new int[GAME_UNITS];
    private int bodyParts = 6;
    private int applesEaten;
    private int appleX;
    private int appleY;
    private char direction = 'R';
    private boolean isRunning = false;
    private boolean pauseIt = false;
    private Timer timer;
    private Random random;
    private JButton startOver;

    private ImageIcon exitIcon;
    public GamePanel(){
        random = new Random();
        startOver = new JButton("Start Over");
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        exitIcon = new ImageIcon("/Users/tanyashkolnik/IdeaProjects/SwingJava/src/054.png");
        this.add(startOver);
        startOver.setVisible(false);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

    }

    public void startGame(){
        makeApple();
        isRunning = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if(isRunning) {
          /*  for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; ++i) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }*/

            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; ++i) {
                if (i == 0) { //head of snake
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                }
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
            g.setColor(Color.white);
            g.setFont(new Font("Chalkduster",Font.BOLD,40));
            FontMetrics metrics = getFontMetrics(g.getFont());

            g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2,g.getFont().getSize());
        }else{
            gameOver(g);
        }

    }

    public void makeApple(){
        appleX = random.nextInt((SCREEN_WIDTH/UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;
    }

    public void move(){
        for(int i = bodyParts;i>0;--i){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch (direction) {
            case 'U' -> y[0] = y[0] - UNIT_SIZE;
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
            case 'R' -> x[0] = x[0] + UNIT_SIZE;
        }
    }

    public void checkApple(){
        if((x[0] == appleX) && (y[0]== appleY)){
            bodyParts++;
            applesEaten++;
            makeApple();
        }
    }

    public void checkCollisions(){
        // checks head collided with body
        for(int i = bodyParts; i>0; --i){
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                isRunning = false;
                break;
            }
        }
        //checks is head touches borders
        if((x[0]< 0) || (x[0] > SCREEN_WIDTH) || (y[0]< 0)|| (y[0]> SCREEN_HEIGHT))
            isRunning = false;

        if(!isRunning) {
            timer.stop();

        }
    }

    public void gameOver(Graphics g){
       startOver.setVisible(true);
        g.setColor(Color.red);
        g.setFont(new Font("Chalkduster",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawImage(exitIcon.getImage(),SCREEN_WIDTH/2,SCREEN_HEIGHT/2,null);
        g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);


        g.setFont(new Font(null,Font.BOLD,40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2,SCREEN_HEIGHT/3);


        startOver.addActionListener(e-> new GameFrame());
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(isRunning){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){


            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if(!pauseIt) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        pauseIt = true;
                        break;
                    }else if(pauseIt){
                        pauseIt = false;
                    }

            }
        }
    }
}
