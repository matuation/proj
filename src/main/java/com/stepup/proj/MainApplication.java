package com.stepup.proj;

public class MainApplication {
    public static void main(String[] args) {
        Dot dotOne = Dot.ofCoordinates(1, 3);
        Dot dotTwo = Dot.ofCoordinates(5, 8);
        Line lineOfDots = Line.ofDots(dotOne, dotTwo);
        Line lineOfPoints = Line.ofCoordinates(10, 11, 15, 19);
        Line lineOfLines = Line.ofDots(lineOfDots.lineEnd, lineOfPoints.lineStart);
        System.out.println("Выведите текстовое представление Линии 3 на экран");
        System.out.println(lineOfLines);
        System.out.println("=================================================");
        System.out.println("Измените координаты точек начала и конца Линии 3 таким образом, чтобы изменились все три объекта Линии");
        lineOfDots.lineEnd = Dot.ofCoordinates(6, 9);
        lineOfPoints.lineStart = Dot.ofCoordinates(11, 12);
        System.out.println(lineOfDots);
        System.out.println(lineOfPoints);
        lineOfLines = Line.ofDots(lineOfDots.lineEnd, lineOfPoints.lineStart);
        System.out.println("Выведите текстовое представление Линии 3 на экран после изменения её состояния");
        System.out.println(lineOfLines);
        System.out.println("=================================================");
        System.out.println("Рассчитайте суммарную длину всех трех линий и выведите её на экран");
        System.out.println(lineOfDots.getLength() + lineOfPoints.getLength() + lineOfLines.getLength());
        System.out.println("=================================================");
    }
}