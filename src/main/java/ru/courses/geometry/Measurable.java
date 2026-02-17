package ru.courses.geometry;

import java.util.ArrayList;

public interface Measurable {

    ArrayList<Point> getPoints();

    default ArrayList<Line> getLines() {
        ArrayList<Line> linesOfPolyLine = new ArrayList<>();
        ArrayList<Point> points = getPoints();
        for (int i = 0; i < points.size() - 1; i++) {
            Line line = Line.ofDots(points.get(i), points.get(i + 1));
            linesOfPolyLine.add(line);
        }

        return linesOfPolyLine;
    }

    default double getLength() {
        double polyLineLength = 0;
        for(Line line : this.getLines()){
            polyLineLength+=line.getLength();
        }
        return polyLineLength;
    }
}
