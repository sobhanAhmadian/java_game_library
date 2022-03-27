package gameEngine.gameObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Animation {

    private BufferedImage[] frames;
    private int currentFrameNumber;
    private int time;
    private int currentTime;

    public Animation(String[] framePaths, int time) {
        frames = new BufferedImage[framePaths.length];
        this.time = time;
        currentFrameNumber = 0;
        try {
            for (int i = 0; i < framePaths.length; i++) {
                frames[i] = ImageIO.read(Objects.requireNonNull(getClass().getResource(framePaths[i])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveFrame() {
        if (++currentTime == time) {
            if (++currentFrameNumber == frames.length) currentFrameNumber = 0;
            currentTime = 0;
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[currentFrameNumber];
    }
}
