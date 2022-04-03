package gameEngine.gameObject;

public class AutoMoverSprite extends Sprite{

    private double xStep;
    private double yStep;
    private double xTemp;
    private double yTemp;

    public AutoMoverSprite(String imagePath) {
        super(imagePath);
    }

    @Override
    public void updatePosition() {

        xTemp += xStep;
        yTemp += yStep;

        if (Math.abs(xTemp) >= 1) {
            setX(getX() + (int) xTemp);
            xTemp = 0;
        }
        if (Math.abs(yTemp) >= 1) {
            setY(getY() + (int) yTemp);
            yTemp = 0;
        }
    }

    public double getXStep() {
        return xStep;
    }

    public void setXStep(double xStep) {
        this.xStep = xStep;
    }

    public double getYStep() {
        return yStep;
    }

    public void setYStep(double yStep) {
        this.yStep = yStep;
    }
}
