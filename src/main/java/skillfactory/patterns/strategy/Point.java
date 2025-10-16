package skillfactory.patterns.strategy;

public class Point {
    private int x;
    private int y;
    // Конструктор, геттеры...

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
