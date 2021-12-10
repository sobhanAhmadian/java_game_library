package gameUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GameHome extends JPanel {

    private BufferedImage backgroundImage;
    private int width;
    private int height;
    private Runner runner;

    public GameHome(String backgroundPath, String runIconPath, String runClickedIconPath, int width, int height) {
        this.width = width;
        this.height = height;

        try {
            backgroundImage = ImageIO.read(Objects.requireNonNull(getClass().getResource(backgroundPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());
        JLabel run = new JLabel();
        Icon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(runIconPath)));
        Icon clickedIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(runClickedIconPath)));
        run.setIcon(icon);
        run.setSize(128, 128);
        run.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                run.setIcon(clickedIcon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                run.setIcon(icon);
                if (runner != null)
                    runner.run();
            }
        });
        add(run, new GridBagConstraints());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(backgroundImage, 0, 0, width, height, null);
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    interface Runner {
        void run();
    }
}
