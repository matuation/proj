package com.stepup.proj;

public class Dot {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
            }

    @Override
    public String toString() {
        return "{" + x +
                ";" + y +
                '}';
    }
}
