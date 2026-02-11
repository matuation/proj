package com.stepup.proj;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
   Fraction f1 = Fraction.of(4,3);
        System.out.println(f1.intValue());
        System.out.println(f1.longValue());
        System.out.println(f1.doubleValue());
        System.out.println(f1.floatValue());
    }
}