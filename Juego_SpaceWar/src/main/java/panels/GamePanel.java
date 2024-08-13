package panels;

import resources.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {

    private Player player;
    private List<Bullet> bullets;
    private List<Meteor> meteors;
    private final int P_WIDTH = 400;
    private final int P_HEIGHT = 400;
    private final int DOT_SIZE = 10;
    private final int MET_SIZE = 20;
    private final int DELAY = 10;
    private final int SHOOTING_DELAY = 500;

    private int meteors_delay_min;
    private int meteors_delay_max;
    private int meteors_delay;
    private int count_meteors_1 = 0;
    private int count_meteors_2 = 0;
    private int meteors_between_1 = new Random().nextInt(7, 16);
    private int meteors_between_2 = new Random().nextInt(3, 6);

    private boolean right_direction = false;
    private boolean left_direction = false;
    private boolean inGame = true;
    private boolean isShooting = false;

    private Timer timer;
    private Timer shootingTimer;
    private Timer meteorsTimer;


    private final int[] x =  {150, 200, 250};
    private final int[] y =  {350, 310, 350};
    private int[] xPoints = x.clone();
    private int[] yPoints = y.clone();
    private final int nPoints = 3;

    private int points = 0;
    private int lives = 3;

    private Color colorPlayer = new Color(200, 150, 100);


    public GamePanel(){

        initGamePanel();
    }

    public void initGamePanel(){
        addKeyListener(new TAdapter());
        setPreferredSize(new Dimension(400, 400));
        setBackground(new Color(20, 20, 45));
        setFocusable(true);

        player = new Player(xPoints, yPoints, nPoints);
        bullets = new ArrayList<>();
        meteors = new ArrayList<>();

        initGame();
    }

    public void initGame(){

        Random random = new Random();

        meteors_delay_min = 1000;
        meteors_delay_max = 4000;

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
                    shoot();
                }
            }
        });

        meteors_delay = random.nextInt(2000,6000);

        meteorsTimer = new Timer(meteors_delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locateMeteor();

                meteors_delay = random.nextInt(meteors_delay_min, meteors_delay_max);
                System.out.println(meteors_delay);
                meteorsTimer.setDelay(meteors_delay);

            }
        });

        meteorsTimer.start();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        doDrowing(g);

        colorPlayer = new Color(200, 150, 100);
    }

    public void doDrowing(Graphics g){
        if(inGame){
            player.draw(g, colorPlayer);
            showPoints(g);
            showLives(g);
            for (Bullet bullet : bullets) {
                bullet.draw(g);
            }
            for(Meteor meteor : meteors){
                meteor.draw(g);
            }
        }
        else {
            gameOver(g);

        }

    }

    private void gameOver(Graphics g) {

        timer.stop();
        shootingTimer.stop();
        meteorsTimer.stop();

        String msgGameOver = "Game Over";
        String msgPlayAgain = "Press \"enter\" to play again";

        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msgGameOver, (P_WIDTH - metr.stringWidth(msgGameOver)) / 2, P_HEIGHT / 2);
        g.drawString(msgPlayAgain, (P_WIDTH - metr.stringWidth(msgPlayAgain)) / 2, P_HEIGHT / 2 + 30);


    }

    private void reboot(){

        initGame();

        xPoints = x.clone();
        yPoints = y.clone();
        player.setxPoints(xPoints);
        player.setyPoints(yPoints);

        bullets.clear();
        meteors.clear();

        points = 0;
        lives = 3;

    }



    public void checkCollision(){

        checkWallCollision();
        checkBulletCollision();
        checkMeteorCollision();

        if(lives == 0){
            inGame = false;
        }
    }


    private void checkWallCollision(){
        if(xPoints[0] <= 0){
            left_direction = false;
        }
        if(xPoints[2] >= P_WIDTH){
            right_direction = false;
        }
    }

    private void checkBulletCollision(){

        for (int i = bullets.size() - 1; i >= 0; i--) {
            Bullet bullet = bullets.get(i);
            for (int j = meteors.size() - 1; j >= 0; j--) {
                Meteor meteor = meteors.get(j);
                if (areRectanglesTouching(bullet.getX(), bullet.getY(), DOT_SIZE, DOT_SIZE, meteor.getX(), meteor.getY(),
                        DOT_SIZE*2, DOT_SIZE*2)) {
                    bullets.remove(i);
                    meteor.reciveDamage();
                    if(meteor.getLife() == 0){
                        meteors.remove(j);
                        points++;
                        accelerateMeteors();
                    }
                }
            }
        }
    }

    private void checkMeteorCollision(){

        for(int k=meteors.size() - 1; k >= 0; k--){
            Meteor meteor = meteors.get(k);
            if(isTriangleCollidingWithRectangle(xPoints, yPoints, meteor.getX(), meteor.getY(),
                    DOT_SIZE*2, DOT_SIZE*2)){
                if(meteor instanceof Meteor_life){
                    lives++;
                }
                else{
                    lives--;
                }
                paintPlayer();
                meteors.remove(k);
            }
        }
    }


    private void showPoints(Graphics g) {


        String msg = "Pts: " + Integer.toString(points);
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.drawString(msg, P_WIDTH - metr.stringWidth(msg) - 10, 20);
    }

    private void showLives(Graphics g){

        String msg = "LIVES: " + Integer.toString(lives);
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.drawString(msg,20, 20);
    }


    public void move(){

        if(left_direction){
            player.moveLeft();
        }
        if(right_direction){
            player.moveRight();
        }

        for (Bullet bullet : bullets) {
            bullet.move();
        }
        bullets.removeIf(bullet -> bullet.isOffScreen(P_HEIGHT));

        for(Meteor meteor : meteors){
            meteor.move();
        }
        meteors.removeIf(meteor -> meteor.isOffScreen(P_HEIGHT));


    }

    public void locateMeteor(){
        Random random = new Random();
        int x_meteor = random.nextInt(50, 350);
        int y_meteor = 0;

        if(meteors_between_2 == count_meteors_2){
            meteors.add(new StrongMeteor(x_meteor, y_meteor, DOT_SIZE*3));
            count_meteors_2 = 0;
            meteors_between_2 = random.nextInt(3,6);
            count_meteors_1++;
        }
        else if(meteors_between_1 == count_meteors_1){
            meteors.add(new Meteor_life(x_meteor, y_meteor, DOT_SIZE*2));
            count_meteors_1 = 0;
            meteors_between_1 = random.nextInt(6, 17);
            count_meteors_2++;
        }
        else{
            meteors.add(new Meteor(x_meteor, y_meteor, DOT_SIZE*2));
            count_meteors_1++;
            count_meteors_2++;
        }

    }

    public void shoot(){
        int x_bullet = player.getXPoints()[1] - 5;
        int y_bullet = player.getYPoints()[1] - 10;
        bullets.add(new Bullet(x_bullet, y_bullet, DOT_SIZE));

    }

    private void paintPlayer(){

        colorPlayer = new Color(200, 100, 100);
        repaint();

    }

    private void accelerateMeteors(){
        if(points == 10){
            meteors_delay_min -= 100;
            meteors_delay_max -= 100;
        } else if (points == 25) {
            meteors_delay_min -= 200;
            meteors_delay_max -= 200;
        } else if (points == 35) {
            meteors_delay_min -= 200;
            meteors_delay_max -= 200;
        } else if (points == 40) {
            meteors_delay_min -= 100;
            meteors_delay_max -= 100;
        } else if (points == 45) {
            meteors_delay_min -= 150;
            meteors_delay_max -= 250;
        } else if (points == 50) {
            meteors_delay_min -= 150;
            meteors_delay_max -= 500;
        } else if (points > 50 && points % 5 == 0 && meteors_delay_max > 100) {
            meteors_delay_max -= 100;
        }
    }

    public static boolean areRectanglesTouching(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
        boolean xOverlap = (x1 < x2 + w2) && (x1 + w1 > x2);
        boolean yOverlap = (y1 < y2 + h2) && (y1 + h1 > y2);

        return xOverlap && yOverlap;
    }

    public static boolean isTriangleCollidingWithRectangle(int[] xPoints, int[] yPoints, int rectX, int rectY, int rectWidth, int rectHeight) {
        // Verificar si algún vértice del triángulo está dentro del rectángulo
        for (int i = 0; i < 3; i++) {
            if (isPointInsideRectangle(xPoints[i], yPoints[i], rectX, rectY, rectWidth, rectHeight)) {
                return true;
            }
        }

        // Verificar si algún vértice del rectángulo está dentro del triángulo
        int[] rectXPoints = {rectX, rectX + rectWidth, rectX + rectWidth, rectX};
        int[] rectYPoints = {rectY, rectY, rectY + rectHeight, rectY + rectHeight};
        for (int i = 0; i < 4; i++) {
            if (isPointInsideTriangle(rectXPoints[i], rectYPoints[i], xPoints, yPoints)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isPointInsideRectangle(int px, int py, int rx, int ry, int rWidth, int rHeight) {
        return (px >= rx && px <= rx + rWidth && py >= ry && py <= ry + rHeight);
    }

    public static boolean isPointInsideTriangle(int px, int py, int[] xPoints, int[] yPoints) {
        double d1 = sign(px, py, xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        double d2 = sign(px, py, xPoints[1], yPoints[1], xPoints[2], yPoints[2]);
        double d3 = sign(px, py, xPoints[2], yPoints[2], xPoints[0], yPoints[0]);

        boolean hasNeg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        boolean hasPos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(hasNeg && hasPos);
    }

    private static double sign(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3);
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
                isShooting = true;
                shootingTimer.start();
                shoot();

            }
            if(!inGame && key == KeyEvent.VK_ENTER){
                inGame = true;
                reboot();
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

}
