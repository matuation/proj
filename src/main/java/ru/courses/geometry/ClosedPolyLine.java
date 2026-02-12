package ru.courses.geometry;

import java.util.ArrayList;

public class ClosedPolyLine extends PolyLine implements Measurable {

    public ClosedPolyLine(ArrayList<Dot> polyLinePoints) {
        super(polyLinePoints);
    }

    @Override
    public ArrayList<Dot> getPoints() {
        return this.polyLinePoints;
    }

    @Override
    public double getLength() {
        double firstLength = super.getLength();
        ArrayList<Line> linesOfClosedPolyLine = this.getLines();
        firstLength += Line.ofDots(linesOfClosedPolyLine.get(linesOfClosedPolyLine.size() - 1).lineEnd, linesOfClosedPolyLine.get(0).lineStart).getLength();
        return firstLength;
    }

    @Override
    public String toString() {
        return "ClosedPolyLine{" +
                "polyLinePoints=" + polyLinePoints +
                '}';
    }
}