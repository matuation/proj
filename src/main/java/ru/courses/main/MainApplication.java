package ru.courses.main;
import ru.courses.geometry.Point;


public class MainApplication {

    public static void main(String[] args) {
        Point point = Point.ofCoordinates(1, 3);
        Point point2 = Point.ofCoordinates(1, 3);
        System.out.println(point.equals(point2));
    }
}