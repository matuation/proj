package com.stepup.proj;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
    Dot dot1 = new Dot(1,5);
    Dot dot2 = new Dot(2,8);
    Dot dot3 = new Dot(3,5);
    ArrayList<Dot> dots = new ArrayList<>(Arrays.asList(dot1,dot2,dot3));
    ClosedPolyLine closedPolyLine = new ClosedPolyLine(dots);
    System.out.println(closedPolyLine.getClosedLinesLength());
    }
}