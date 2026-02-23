package ru.courses.math;

import java.util.Scanner;

public class Sum2 {
    public static void main(String[] args) {
        double sum = 0;
        double[] digits = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            Scanner consoleInput = new Scanner(args[i]);
            if (consoleInput.hasNextDouble()) {
                digits[i] = Double.parseDouble(args[i]);
                sum += digits[i];
            } else {
                digits[i] = 0;
            }
        }
        System.out.println(sum);
    }
}
