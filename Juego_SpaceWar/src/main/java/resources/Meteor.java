package resources;

import java.awt.*;

public class Meteor extends Dot{


    public Meteor(int x, int y, int size) {
        super(x, y, size);
        speed = 1;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(100, 50, 10));
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

}
