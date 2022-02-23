package gameEngine.gameObject;

import java.awt.*;

public abstract class Camera extends GameObject {

    @Override
    public void paint(Graphics2D graphics2D, Camera camera) {}

    public void moveCenter(int x, int y) {
        setX(x - (getWidth() / 2));
        setY(y - (getHeight() / 2));
    }
}
