package gameEngine;

public interface GameListener {

    void onUpButtonClicked();

    void onDownButtonClicked();

    void onRightButtonClicked();

    void onLeftButtonClicked();

    void onSpaceButtonClicked();

    void onRightMouseButtonClicked(int x, int y);

    void onLeftMouseButtonClicked(int x, int y);
}
