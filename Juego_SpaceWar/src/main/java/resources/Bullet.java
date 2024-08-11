package resources;

import java.awt.*;

public class Bullet extends Dot{

    public Bullet(int x, int y, int size) {
        super(x, y, size);
        speed = 3;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, size, size);
    }

    @Override
    public void move() {
        y -= speed;
    }

    @Override
    public boolean isOffScreen(int screenHeight) {
        return y < 0;
    }

}

