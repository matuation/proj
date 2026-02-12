package ru.сourses.geometry;

public class Dot {
    public int x;
    public int y;

    private Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Dot ofCoordinates(int x, int y) {
        return new Dot(x, y);
    }

    @Override
    public String toString() {
        return "{" + x +
                ";" + y +
                '}';
    }
}
