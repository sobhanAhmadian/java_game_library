package gameEngine.gameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class TileMap extends GameObject {

    private int[][] map;
    private final BufferedImage[] tiles;
    private int n;
    private int m;
    private final int tileWidth;
    private final int tileHeight;
    private Color emptySpaceColor;

    public TileMap(String tileFilePath, String[] tiles, int tileWidth, int tileHeight, Color emptySpaceColor) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.emptySpaceColor = emptySpaceColor;

        this.tiles = new BufferedImage[tiles.length];
        try {
            for (int i = 0; i < tiles.length; i++) {
                this.tiles[i] = ImageIO.read(Objects.requireNonNull(getClass().getResource(tiles[i])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            URL url = getClass().getResource(tileFilePath);
            File file = new File(Objects.requireNonNull(url).getPath());
            Scanner scanner = new Scanner(file);
            n = scanner.nextInt();
            m = scanner.nextInt();
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics2D graphics2D, Camera camera) {

        BufferedImage result = new BufferedImage(
                m * tileWidth, n * tileHeight,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) result.getGraphics();
        g.setColor(emptySpaceColor);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int rx = j * tileWidth;
                int ry = i * tileHeight;
                AffineTransform transform = new AffineTransform();
                transform.translate(rx, ry);

                if (map[i][j] == -1) g.fillRect(rx, ry, tileWidth, tileHeight);
                else {
                    BufferedImage tile = tiles[map[i][j]];
                    Image newImage = tile.getScaledInstance(tileWidth, tileHeight, Image.SCALE_DEFAULT);
                    g.drawImage(newImage, transform, null);
                }
            }
        }

        int rx = getX() - camera.getX();
        int ry = getY() - camera.getY();
        AffineTransform transform = new AffineTransform();
        transform.translate(rx, ry);

        graphics2D.drawImage(result, transform, null);
    }

    @Override
    public void update() {

    }
}
