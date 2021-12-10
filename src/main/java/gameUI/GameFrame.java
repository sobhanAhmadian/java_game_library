package gameUI;

import gameEngine.Game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame implements Game.HomeCallback{

    private Game game;
    private GameHome gameHome;

    public GameFrame(int width, int height,
                     Game game, GameHome gameHome) {
        this.game = game;
        this.game.setHomeCallback(this);
        this.gameHome = gameHome;

        setSize(width, height);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gameHome.setRunner(this::runGame);
        add(gameHome, BorderLayout.CENTER);

        setVisible(true);
    }

    private void runGame() {
        remove(gameHome);
        add(game);
        game.start();
    }

    @Override
    public void goToHome() {
        remove(game);
        game.finish();
        add(gameHome);
        gameHome.repaint();
    }
}
