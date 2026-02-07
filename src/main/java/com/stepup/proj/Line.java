package com.stepup.proj;

public class Line {
    Dot lineStart;
    Dot lineEnd;

    public Line(Dot lineStart, Dot lineEnd) {
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
    }
    public static Line LineOfCoordinates(int xStart, int yStart,int xEnd, int yEnd) {
        Dot pointStart = new Dot(xStart, yStart);
        Dot pointEnd = new Dot(xEnd, yEnd);
        return new Line(pointStart, pointEnd);
    }

    @Override
    public String toString() {
        return "Линия от" +
                 lineStart +
                "до" + lineEnd
                ;
    }
}
