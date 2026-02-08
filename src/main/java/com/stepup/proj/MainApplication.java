package com.stepup.proj;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        Dot dot1 = Dot.ofCoordinates(1, 5);
        Dot dot2 = Dot.ofCoordinates(2, 8);
        Dot dot3 = Dot.ofCoordinates(5, 3);
        Dot dot4 = Dot.ofCoordinates(8, 9);
        ArrayList<Dot> dotsList = new ArrayList<>((List.of(dot1, dot2, dot3, dot4)));
        System.out.println("==================START===================");
        System.out.println("======================================");
        System.out.println("1. Создать Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}, {8,9}");
        PolyLine polyLine = PolyLine.ofLines(dotsList);
        System.out.println("Создана ломаная, состоящая из точек: " + polyLine);
        System.out.println("======================================");
        System.out.println("2. Рассчитать длину Ломаной");
        System.out.println("Длина созданной ломаной: " + polyLine.getLength());
        System.out.println("======================================");
        System.out.println("3. Получить у Ломаной массив Линий");
        System.out.println("Массив линий созданной ломаной: " + polyLine.getLines());
        System.out.println("======================================");
        System.out.println("4. Рассчитать длину массива Линий");
        ArrayList<Line> lineArray = new ArrayList<>(polyLine.getLines());
        double lineArrayLength = 0;
        for (int i = 0; i < lineArray.size(); i++) {
            lineArrayLength += lineArray.get(i).getLength();
        }
        System.out.println("Длина массива Линий: " + lineArrayLength);
        System.out.println("5. Сравнить длину Ломаной и массива Линий: они должны совпасть");
        System.out.println("Длина массива линий = длине Ломаной? " + (lineArrayLength == polyLine.getLength()));
        System.out.println("======================================");
        System.out.println("6. Изменить координаты Точки {2,8} на {12,8}");
        dot2.x = 12;
        System.out.println("Координаты точки 2 теперь: " + dot2);
        System.out.println("Ломаная теперь состоит из точек: " + polyLine);
        System.out.println("Ломаная теперь состоит из линий: " + polyLine.getLines());
        System.out.println("Длина ломаной теперь: " + polyLine.getLength());
        System.out.println("==================END===================");
    }
}