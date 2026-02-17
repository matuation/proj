package ru.courses.geometry;

public class Line {
    Point lineStart;
    Point lineEnd;

    private Line(Point lineStart, Point lineEnd) {
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
    }

    static Line ofDots(Point lineStart, Point lineEnd) {
        return new Line(lineStart, lineEnd);
    }

    static Line ofCoordinates(int xStart, int yStart, int xEnd, int yEnd) {
        Point pointStart = Point.ofCoordinates(xStart, yStart);
        Point pointEnd = Point.ofCoordinates(xEnd, yEnd);
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
