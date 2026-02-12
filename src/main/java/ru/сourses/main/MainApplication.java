package ru.сourses.main;

import ru.сourses.geometry.ClosedPolyLine;
import ru.сourses.geometry.Dot;
import ru.сourses.geometry.PolyLine;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        Dot dot1 = Dot.ofCoordinates(1,5);
        Dot dot2 = Dot.ofCoordinates(2,8);
        Dot dot3 = Dot.ofCoordinates(3,5);
        ArrayList<Dot> dots = new ArrayList<>(Arrays.asList(dot1,dot2,dot3));
        ClosedPolyLine closedPolyLine = new ClosedPolyLine(dots);
        PolyLine line = new PolyLine(dots);
        System.out.println(line.getLength());
        System.out.println(closedPolyLine.getLength());
    }
}