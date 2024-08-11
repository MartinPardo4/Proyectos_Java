package resources;

import java.awt.*;

public abstract class Dot {

    protected int x;
    protected int y;
    protected int size;
    protected int speed;

    public Dot(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public abstract void move();
    public abstract void draw(Graphics g);
    public abstract boolean isOffScreen(int screenHeight);


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
