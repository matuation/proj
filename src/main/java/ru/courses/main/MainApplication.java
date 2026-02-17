package ru.courses.main;
import ru.courses.geometry.Point;


public class MainApplication {

    public static void main(String[] args) {
        Point point = Point.ofCoordinates(1, 3);
        java.awt.Point point1 = new java.awt.Point(1, 2);
        System.out.println(point);
        System.out.println(point1);
    }
}