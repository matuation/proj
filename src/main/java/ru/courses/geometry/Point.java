package ru.courses.geometry;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{" + x +
                ";" + y +
                '}';
    }

    @Override
    public Point clone() throws CloneNotSupportedException {
        return new Point(x,y);
    }
}
