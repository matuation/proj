package ru.courses.geometry;

import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Measurable {
    ArrayList<Dot> polyLinePoints = new ArrayList<>();
    static ArrayList<Dot> noPoints = new  ArrayList<>((List.of(Dot.ofCoordinates(0,0))));

    public PolyLine(ArrayList<Dot> polyLinePoints) {
        this.polyLinePoints = polyLinePoints;
    }

    static PolyLine ofLines(ArrayList<Dot> polyLinePoints) {
        return new PolyLine(polyLinePoints);

    }

    static PolyLine ofNoting() {
        return new PolyLine(noPoints);
    }

    @Override
    public ArrayList<Dot> getPoints() {
        return this.polyLinePoints;
    }

    public ArrayList getLines() {
        ArrayList<Line> linesOfPolyLine = new ArrayList<>();
        for (int i = 0; i < polyLinePoints.size() - 1; i++) {
            Line line = Line.ofDots(polyLinePoints.get(i), polyLinePoints.get(i + 1));
            linesOfPolyLine.add(line);
        }

        return linesOfPolyLine;
    }

    @Override
    public String toString() {
        return "Линия " +
                polyLinePoints;
    }
}
