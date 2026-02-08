package com.stepup.proj;

import java.util.ArrayList;

public class PolyLine {
    ArrayList<Dot> polyLinePoints = new ArrayList<>();

    private PolyLine(ArrayList<Dot> polyLinePoints) {
        this.polyLinePoints = polyLinePoints;
    }

    static PolyLine ofLines(ArrayList<Dot> polyLinePoints) {
        return new PolyLine(polyLinePoints);

    }

    static PolyLine ofNoting() {
        return new PolyLine(null);
    }

    public ArrayList getLines() {
        ArrayList<Line> linesOfPolyLine = new ArrayList<>();
        for (int i = 0; i < polyLinePoints.size() - 1; i++) {
            if (i % 2 == 0) {
                Line line = Line.ofDots(polyLinePoints.get(i), polyLinePoints.get(i + 1));
                linesOfPolyLine.add(line);
            } else {
                Line line = Line.ofDots(polyLinePoints.get(i), polyLinePoints.get(i + 1));
                linesOfPolyLine.add(line);
            }
        }
        return linesOfPolyLine;
    }

    public double getLength() {
        double polyLineLength = 0;
        for (int i = 0; i < this.getLines().size(); i++){
            Line line = (Line) this.getLines().get(i);
            polyLineLength+=line.getLength();
        }
    return polyLineLength;
    }

    @Override
    public String toString() {
        return "Линия " +
                polyLinePoints;
    }
}
