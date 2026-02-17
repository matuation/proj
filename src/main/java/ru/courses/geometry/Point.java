package ru.courses.geometry;

public class Point {
    public int x;
    public int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point ofCoordinates(int x, int y) {
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "{" + x +
                ";" + y +
                '}';
    }
}
