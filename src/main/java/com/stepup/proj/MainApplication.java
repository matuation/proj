package com.stepup.proj;

public class MainApplication {
    public static void main(String[] args) {
        Fraction f1 = Fraction.of(3, 5);
        Fraction f2 = Fraction.of(49, 12);
        Fraction f3 = Fraction.of(3, 2);
        Fraction f4 = Fraction.of(1, 3);

        System.out.println(Fraction.sumAll(2, f1, 2.3));
        System.out.println(Fraction.sumAll(3.6, f2, 3, f3));
        System.out.println(Fraction.sumAll(f4, 1));

    }
}