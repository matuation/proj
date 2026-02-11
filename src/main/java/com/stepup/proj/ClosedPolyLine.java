package com.stepup.proj;

import java.util.ArrayList;

public class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(ArrayList<Dot> polyLinePoints) {
        super(polyLinePoints);
    }
    public double getClosedLinesLength() {
        ClosedPolyLine closedLine = new ClosedPolyLine(polyLinePoints);
        ArrayList<Line> linesOfClosedPolyLine =  this.getLines();
        int arrayLastElement = linesOfClosedPolyLine.size() - 1;
        Line lastLine = Line.ofDots(linesOfClosedPolyLine.get(arrayLastElement).lineEnd, linesOfClosedPolyLine.get(0).lineStart);
        double closedLineLegth = closedLine.getLength() + lastLine.getLength();
                return closedLineLegth;
        }
    @Override
    public String toString() {
        return "ClosedPolyLine{" +
                "polyLinePoints=" + polyLinePoints +
                '}';
    }
}