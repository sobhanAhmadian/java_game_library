package gameEngine.gameObject;

import gameEngine.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Sprite extends GameObject {

    private BufferedImage image;
    private final List<Animation> animations;
    private int currentAnimationIndex;
    private boolean flip = false;

    public Sprite(String imagePath) {
        animations = new ArrayList<>();
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        if (animations.size() > 0) {
            image = animations.get(currentAnimationIndex).getCurrentFrame();
            animations.get(currentAnimationIndex).moveFrame();
        }
        updatePosition();
    }

    @Override
    public void paint(Graphics2D graphics2D, Camera camera) {
        int rx = getX() - camera.getX();
        int ry = getY() - camera.getY();
        AffineTransform transform = new AffineTransform();
        transform.translate(rx, ry);
        transform.quadrantRotate(getAngle());
        transform.translate(-(float) (getWidth() / 2), -(float) (getHeight() / 2));

        if (flip) {
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-image.getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            image = op.filter(image, null);
        }

        Image newImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);

        graphics2D.drawImage(newImage, transform, null);
    }

    public void addAnimation(Animation animation) {
        animations.add(animation);
    }

    public abstract void updatePosition();

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        resizeImage();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        resizeImage();
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public boolean getFlip() {
        return this.flip;
    }

    private void resizeImage() {
        image = Util.resize(image, getWidth(), getHeight());
    }

    public void setCurrentAnimationIndex(int currentAnimationIndex) {
        this.currentAnimationIndex = currentAnimationIndex;
    }
}
