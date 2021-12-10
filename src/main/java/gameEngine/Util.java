package gameEngine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Util {
    public static BufferedImage resize(BufferedImage img, int newWidth, int newHeight) {

        newWidth = newWidth == 0 ? 50 : newWidth;
        newHeight = newHeight == 0 ? 50 : newHeight;

        Image tmp = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return image;
    }
}
