package ru.courses.main;


import ru.courses.geometry.ClosedPolyLine;
import ru.courses.geometry.Measurable;
import ru.courses.geometry.Point;
import ru.courses.geometry.PolyLine;

import java.util.ArrayList;
import java.util.List;


public class MainApplication {
    public static double sumOfAllLengths(List<Measurable> items) {
        double allLength = 0;
        for (Measurable item : items) {
            allLength += item.getLength();
        }
        return allLength;
    }

    public static void main(String[] args) {
        Point point1 = Point.ofCoordinates(1, 8);
        Point point2 = Point.ofCoordinates(3, 4);
        Point point3 = Point.ofCoordinates(5, 1);
        ArrayList<Point> points = new ArrayList<>(List.of(point1, point2, point3));
        PolyLine polyLine = new PolyLine(points);
        ClosedPolyLine closedPolyLine = new ClosedPolyLine(points);
        List<Measurable> measurables = List.of(polyLine, closedPolyLine);
        System.out.println(sumOfAllLengths(measurables));
    }
}