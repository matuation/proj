package ru.courses.main;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class MainApplication {
    public static void main(String[] args) {
        String x = args[0]; // первый параметр
        String y = args[1];  // второй параметр
        System.out.println(powerOfXY(x, y));
    }

    public static double powerOfXY(String x, String y) {
        double xI = parseInt(x);
        double yI = parseInt(y);
        return pow(xI, yI);

    }
}