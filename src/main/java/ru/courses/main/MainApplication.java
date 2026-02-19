package ru.courses.main;
import ru.courses.geometry.ClosedPolyLine;
import ru.courses.geometry.Line;
import ru.courses.geometry.Point;

import java.util.ArrayList;
import java.util.List;


public class MainApplication {

    public static void main(String[] args) throws CloneNotSupportedException {
        //Points
        System.out.println("==========Points============");
        Point point1 = Point.ofCoordinates(1, 3);
        Point point2 = Point.ofCoordinates(1, 3);
        Point point4 = Point.ofCoordinates(1, 3);
        Point point5 = Point.ofCoordinates(1, 3);
        System.out.println(point1.equals(point2));
        System.out.println(point1==point2);
        Point point3 = point1.clone();
        System.out.println(point1.equals(point3));
        System.out.println(point1==point3);
        point3.x = 3;
        System.out.println("============================");
        System.out.println("===========Lines============");
        Line line1 = Line.ofDots(point1, point2);
        Line line2 = Line.ofDots(point1, point2);
        System.out.println(line1.equals(line2));
        System.out.println(line1==line2);
        Line line3 = new Line(line1);
        System.out.println(line1.equals(line3));
        System.out.println(line1==line3);
        System.out.println("============================");
        System.out.println("=======closedPolyLine=======");
        ArrayList<Point> linesArray1 = new ArrayList(List.of(point1, point2));
        ArrayList<Point> linesArray2 = new ArrayList(List.of(point4, point5));
        ClosedPolyLine closedPolyLine1 = new ClosedPolyLine(linesArray1);
        ClosedPolyLine closedPolyLine2 = new ClosedPolyLine(linesArray2);
        System.out.println(closedPolyLine1.equals(closedPolyLine2));
        System.out.println(closedPolyLine1==closedPolyLine2);
        System.out.println("============================");
    }
}