package ru.courses.geometry;

import java.util.ArrayList;

public class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(ArrayList<Point> polyLinePoints) {
        super(polyLinePoints);
    }

    @Override
    public ArrayList<Point> getPoints() {
        return getPolyLinePoints();
    }

    @Override
    public double getLength() {
        double firstLength = super.getLength();
        ArrayList<Line> linesOfClosedPolyLine = this.getLines();
        firstLength += Line.ofDots(linesOfClosedPolyLine.get(linesOfClosedPolyLine.size() - 1).getLineEnd(), linesOfClosedPolyLine.get(0).getLineStart()).getLength();
        return firstLength;
    }

    @Override
    public String toString() {
        return "ClosedPolyLine{" +
                "polyLinePoints=" + getPolyLinePoints() +
                '}';
    }
}