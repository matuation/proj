package com.stepup.proj;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("==============START===============");
        System.out.println("1. Создать несколько экземпляров дробей");
        Fraction f1 = Fraction.of(1, 3);
        Fraction f2 = Fraction.of(2, 5);
        Fraction f3 = Fraction.of(7, 8);
        System.out.println("Созданы дроби:" + f1 + ", " + f2 + ", " + f3);
        System.out.println("==================================");
        System.out.println("2. Посчитать f1.sum(f2).sum(f3).minus(5)");
        System.out.println(f1 + ".sum(" + f2 + ").sum(" + f3 + ").minus(5)= " + f1.sum(f2).sum(f3).minus(5));
        System.out.println("===============END================");
    }
}