package gameEngine;

import javax.swing.*;

public abstract class Game extends JPanel {

    private HomeCallback homeCallback;

    public abstract void start();

    public abstract void finish();

    public interface HomeCallback {
        void goToHome();
    }

    public HomeCallback getHomeCallback() {
        return homeCallback;
    }

    public void setHomeCallback(HomeCallback homeCallback) {
        this.homeCallback = homeCallback;
    }
}
