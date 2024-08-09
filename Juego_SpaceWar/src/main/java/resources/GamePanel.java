package resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {

    private final int P_WIDTH = 400;
    private final int P_HEIGHT = 400;
    private final int DOT_SIZE = 10;
    private final int MET_SIZE = 20;
    private final int DELAY = 10;
    private final int SHOOTING_DELAY = 500;


    private boolean right_direction = false;
    private boolean left_direction = false;
    private boolean inGame = true;
    private boolean isShooting = false;
    private boolean isShot = false;

    private Timer timer;
    private Timer shootingTimer;

    private final int[] xPoints = new int[]{150, 200, 250};
    private final int[] yPoints = new int[]{350, 310, 350};;
    private final int nPoints = 3;

    private List<Integer> x_bullets = new ArrayList<>();
    private List<Integer> y_bullets = new ArrayList<>();

    public GamePanel(){
        initGamePanel();
    }

    public void initGamePanel(){
        addKeyListener(new TAdapter());
        setPreferredSize(new Dimension(400, 400));
        setBackground(new Color(20, 20, 45));
        setFocusable(true);

        initGame();
    }

    public void initGame(){


        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inGame){
                    checkCollision();
                    move();
                }
                repaint();

            }
        });
        timer.start();

        shootingTimer = new Timer(SHOOTING_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isShooting) {
                    locateBullet();
                }
            }
        });

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        doDrowing(g);
    }

    public void doDrowing(Graphics g){

        g.setColor(new Color(200, 150, 100));
        g.fillPolygon(xPoints, yPoints, nPoints);

        if(isShooting){
            g.setColor(Color.RED);
            for(int i=0; i<x_bullets.size(); i++){
                g.fillRect(x_bullets.get(i), y_bullets.get(i), DOT_SIZE, DOT_SIZE);
            }
        } else if (isShot) {
            g.setColor(Color.RED);
            for(int i=0; i<x_bullets.size(); i++){
                g.fillRect(x_bullets.get(i), y_bullets.get(i), DOT_SIZE, DOT_SIZE);
            }
        }


    }

    public void checkCollision(){

        if(xPoints[0] <= 0){
            left_direction = false;
        }
        if(xPoints[2] >= P_WIDTH){
            right_direction = false;
        }

    }

    public void move(){

        if(left_direction){
            for(int i=0; i<nPoints; i++){
                xPoints[i] -= 5;
            }
        }
        if(right_direction){
            for(int i=0; i<nPoints; i++){
                xPoints[i] += 5;
            }
        }
        if(isShot){
            shoot();
        }


    }

    public void locateBullet(){
        int x_bullet = xPoints[1]-5;
        int y_bullet = yPoints[1]-10;

        x_bullets.add(x_bullet);
        y_bullets.add(y_bullet);
    }

    public void shoot(){
        for(int i=0; i<y_bullets.size(); i++){
            int yB = y_bullets.get(i);
            yB -= 3;
            y_bullets.set(i, yB);
        }

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event){

            int key = event.getKeyCode();

            if(key == KeyEvent.VK_LEFT){
                left_direction = true;
                right_direction = false;
            }
            else if(key == KeyEvent.VK_RIGHT){
                right_direction = true;
                left_direction = false;
            }
            if(key == KeyEvent.VK_SPACE && !isShooting){
                isShot = true;
                isShooting = true;
                locateBullet();
                shootingTimer.start();
            }

        }



        @Override
        public void keyReleased(KeyEvent event){

            int key = event.getKeyCode();

            if(key == KeyEvent.VK_SPACE){
                isShooting = false;
                shootingTimer.stop();
                //isShot = true;
            }

            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
                left_direction = false;
                right_direction = false;
            }
        }

    }


    public int[] getxPoints() {
        return xPoints;
    }

    public int[] getyPoints() {
        return yPoints;
    }
}
