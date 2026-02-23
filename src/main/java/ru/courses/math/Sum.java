package ru.courses.math;

public class Sum {
    public static void main(String[] args) {
        double sum = 0;
        double[] digits = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                digits[i] = Double.parseDouble(args[i]);
                sum += digits[i];
            } catch (NumberFormatException e) {
                digits[i] = 0;
            }
        }
        System.out.println(sum);
    }
}
