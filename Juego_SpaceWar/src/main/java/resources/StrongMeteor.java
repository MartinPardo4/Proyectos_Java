package resources;

import java.awt.*;

public class StrongMeteor extends Meteor{

    public StrongMeteor(int x, int y, int size) {
        super(x, y, size);
        color = new Color(120, 90, 90);
        life = 3;
    }
}
