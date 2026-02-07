package com.stepup.proj;

public class Dot {
    int x;
    int y;

    private Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Dot ofCoordinates(int x, int y) {
        return new Dot(x, y);
    }

    @Override
    public String toString() {
        return "{" + x +
                ";" + y +
                '}';
    }
}
