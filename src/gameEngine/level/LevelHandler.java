package gameEngine.level;

import java.util.ArrayList;
import java.util.List;

public class LevelHandler<T extends Level> {

    private static LevelHandler levelHandler;
    private List<T> levels;
    private int currentLevel;

    private LevelHandler() {
        levels = new ArrayList<>();
    }

    public static <E extends Level> LevelHandler<E> getLevelHandler() {
        if (levelHandler == null) levelHandler = new LevelHandler<E>();
        return levelHandler;
    }

    public T getCurrentLevel() {
        return levels.get(currentLevel);
    }

    public T getNextLevel() {
        return levels.get(currentLevel + 1);
    }

    public void addAllLevels(List<T> levels) {
        this.levels.addAll(levels);
    }

    public void goToNextLevel() {
        currentLevel++;
    }
}
