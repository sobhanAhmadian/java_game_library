package gameUI.dialogue;

import java.awt.*;
import java.awt.event.ActionListener;

public class GameWinDialog extends Dialog {

    public GameWinDialog(Component parent, ActionListener homeListener, ActionListener repeatListener
            , String iconPath, String fontPath) {
        super(
                parent,
                "",
                "You Have Done a Great Gob!",
                350,
                iconPath,
                "Home",
                "Next Level",
                homeListener,
                repeatListener,
                fontPath);
    }
}
