package ru.courses.geometry;

import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Measurable {
    static ArrayList<Point> noPoints = new ArrayList<>((List.of(Point.ofCoordinates(0, 0))));
    private ArrayList<Point> polyLinePoints = new ArrayList<>();

    public PolyLine(ArrayList<Point> polyLinePoints) {
        this.polyLinePoints = polyLinePoints;
    }

    static PolyLine ofLines(ArrayList<Point> polyLinePoints) {
        return new PolyLine(polyLinePoints);

    }

    static PolyLine ofNoting() {
        return new PolyLine(noPoints);
    }

    public ArrayList<Point> getPolyLinePoints() {
        return polyLinePoints;
    }

    @Override
    public ArrayList<Point> getPoints() {
        return this.polyLinePoints;
    }

    public ArrayList<Line> getLines() {
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
