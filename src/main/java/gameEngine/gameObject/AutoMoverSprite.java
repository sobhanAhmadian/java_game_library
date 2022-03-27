package gameEngine.gameObject;

public class AutoMoverSprite extends Sprite{

    private int xStep;
    private int yStep;

    public AutoMoverSprite(String imagePath) {
        super(imagePath);
    }

    @Override
    public void updatePosition() {
        setX(getX() + xStep);
        setY(getY() + yStep);
    }

    public int getxStep() {
        return xStep;
    }

    public void setxStep(int xStep) {
        this.xStep = xStep;
    }

    public int getyStep() {
        return yStep;
    }

    public void setyStep(int yStep) {
        this.yStep = yStep;
    }
}
