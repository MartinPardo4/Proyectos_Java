package resources;

import java.awt.*;

public class Player {
    private int[] xPoints;
    private int[] yPoints;
    private final int nPoints;
    private final int moveSpeed = 5;

    public Player(int[] xPoints, int[] yPoints, int nPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = nPoints;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(200, 150, 100));
        g.fillPolygon(xPoints, yPoints, nPoints);
    }

    public void moveLeft() {
        for (int i = 0; i < nPoints; i++) {
            xPoints[i] -= moveSpeed;
        }
    }

    public void moveRight() {
        for (int i = 0; i < nPoints; i++) {
            xPoints[i] += moveSpeed;
        }
    }

    public int[] getXPoints() {
        return xPoints;
    }

    public int[] getYPoints() {
        return yPoints;
    }

    public void setxPoints(int[] xPoints) {
        this.xPoints = xPoints;
    }

    public void setyPoints(int[] yPoints) {
        this.yPoints = yPoints;
    }
}

