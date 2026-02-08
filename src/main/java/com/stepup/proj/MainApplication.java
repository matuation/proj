package com.stepup.proj;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        ArrayList<Integer> g1 = new ArrayList<>(Arrays.asList(3, 2, 3));
        ArrayList<Integer> g2 = new ArrayList<>(Arrays.asList(4, 4, 3));
        ArrayList<Integer> g3 = new ArrayList<>(Arrays.asList(5, 5, 3, 2));
        ArrayList<Integer> g4 = new ArrayList<>(Arrays.asList(5, 5, 3));


        System.out.println("=================START================");
        System.out.println("Создадим и выведем студента без оценок");
        Student sasha = new Student("Alexander");
        System.out.println(sasha);
        System.out.println("======================================");
        System.out.println("Добавим студенту массив оценок и выведем результат на экран");
        sasha.setGrades(g1);
        System.out.println(sasha);
        System.out.println("======================================");
        System.out.println("Изменим студенту массив оценок и выведем результат на экран");
        sasha.setGrades(g2);
        System.out.println(sasha);
        System.out.println("======================================");
        System.out.println("Получим оценки и выведем их на экран");
        System.out.println(sasha.getGrades());
        System.out.println("======================================");
        System.out.println("Добавим оценку в массив и выведем результат на экран");
        sasha.setGrades(g3);
        System.out.println(sasha);
        System.out.println("======================================");
        System.out.println("Создадим и выведем студента c оценками");
        Student dmitry = new Student("Dmitry", g1);
        System.out.println(dmitry);
        System.out.println("======================================");
        System.out.println("Изменим студенту массив оценок и выведем результат на экран");
        dmitry.setGrades(g2);
        System.out.println(dmitry);
        System.out.println("======================================");
        System.out.println("Получим оценки и выведем их на экран");
        System.out.println(dmitry.getGrades());
        System.out.println("======================================");
        System.out.println("Добавим оценку в массив и выведем результат на экран");
        dmitry.setGrades(g3);
        System.out.println(dmitry);
        System.out.println("======================================");
        System.out.println("Удалим оценку из массива и выведем результат на экран");
        dmitry.setGrades(g1);
        System.out.println(dmitry);
    }
}