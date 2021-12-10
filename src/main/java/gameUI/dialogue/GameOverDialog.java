package gameUI.dialogue;

import java.awt.*;
import java.awt.event.ActionListener;

public class GameOverDialog extends Dialog {
    public GameOverDialog(Component parent, ActionListener repeatListener, String iconPath, String fontPath) {
        super(
                parent,
                "",
                "Sorry You Are Game Over",
                350,
                iconPath,
                "Exit",
                "Repeat",
                actionEvent -> System.exit(0),
                repeatListener,
                fontPath);
    }
}
