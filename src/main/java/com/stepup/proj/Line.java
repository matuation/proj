package com.stepup.proj;

public class Line {
    Dot lineStart;
    Dot lineEnd;

    private Line(Dot lineStart, Dot lineEnd) {
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
    }

    static Line ofDots(Dot lineStart, Dot lineEnd) {
        return new Line(lineStart, lineEnd);
    }

    static Line ofCoordinates(int xStart, int yStart, int xEnd, int yEnd) {
        Dot pointStart = Dot.ofCoordinates(xStart, yStart);
        Dot pointEnd = Dot.ofCoordinates(xEnd, yEnd);
        return new Line(pointStart, pointEnd);
    }

    public double getLength() {

        int catetOne = this.lineEnd.x - this.lineStart.x;
        int catetTwo = this.lineEnd.y - this.lineStart.y;
        int length = (int) (Math.pow(catetOne, 2) + Math.pow(catetTwo, 2));
        return Math.sqrt(length);
    }

    @Override
    public String toString() {
        return "Линия от " +
                lineStart +
                " до " + lineEnd
                ;
    }
}
