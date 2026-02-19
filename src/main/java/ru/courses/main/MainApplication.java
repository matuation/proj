package ru.courses.main;
import ru.courses.geometry.Point;


public class MainApplication {

    public static void main(String[] args) throws CloneNotSupportedException {
        //Points
        System.out.println("==========Points============");
        Point point1 = Point.ofCoordinates(1, 3);
        Point point2 = Point.ofCoordinates(1, 3);
        System.out.println(point1.equals(point2));
        System.out.println(point1==point2);
        Point point3 = point1.clone();
        System.out.println(point1.equals(point3));
        System.out.println(point1==point3);
        System.out.println("============================");
    }
}