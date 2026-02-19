package ru.courses.geometry;

import java.util.ArrayList;
import java.util.Objects;

public class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(ArrayList<Point> polyLinePoints) {
        super(polyLinePoints);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.getPolyLinePoints());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){return true;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        ClosedPolyLine closedPolyLine = (ClosedPolyLine) obj;
        return Objects.equals(this.getPolyLinePoints(), closedPolyLine.getPolyLinePoints());
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