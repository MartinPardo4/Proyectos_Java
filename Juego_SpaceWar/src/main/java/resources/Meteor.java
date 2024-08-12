package resources;

import java.awt.*;

public class Meteor extends Dot{

    protected Color color;
    protected int life = 1;

    public Meteor(int x, int y, int size) {
        super(x, y, size);
        color = new Color(100, 50, 10);
        speed = 1;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }

    @Override
    public void move() {
        y += speed;
    }

    @Override
    public boolean isOffScreen(int screenHeight) {
        return y >= screenHeight;
    }

    public void reciveDamage(){
        life--;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

}
