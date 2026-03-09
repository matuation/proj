package ru.courses;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySort {
    public ArraySort() {
    }

    public static void bubbleSort(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            for (int j = 0; j < intArray.length - i - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                }
            }
        }
    }

    public static void reverse(ArrayList<Integer> intArray) {
        int n = intArray.size();
        for (int i = 0; i < intArray.size() / 2; i++) {
            int temp = intArray.get(i);
            intArray.set(i,intArray.get(n-1-i));
            intArray.set(n-1-i, temp);
        }
    }
}
