package com.stepup.proj;

import java.lang.reflect.Array;
import java.util.Arrays;


public class ArrayMethods {
    //Поиск первого значения
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    //Поиск последнего значения
    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    //Поиск максимального
    public static int maxAbs(int[] arr) {
        int maxArrayValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(maxArrayValue))
                maxArrayValue = arr[i];
        }
        return maxArrayValue;
    }

    //Подсчет позитива
    public static int countPositive(int[] arr) {
        int positiveCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                positiveCounter++;
        }
        return positiveCounter;
    }

    //Палиндром
    public static boolean palindrom(int[] arr) {
        int equalersCounter = 0;
        int arrayBack = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[arrayBack]) {
                equalersCounter++;
                arrayBack--;
            }
        }
        if (equalersCounter == arr.length) {
            return true;
        }
        return false;
    }

    //Реверс
    public static void reverse(int[] arr) {
        int positionCounter = 0;
        int previousValue = 0;
        for (int i = arr.length - 1; i > positionCounter; i--) {
            previousValue = arr[positionCounter];
            arr[positionCounter] = arr[i];
            arr[i] = previousValue;
            positionCounter++;
        }
        System.out.println(Arrays.toString(arr));
    }

    //Возвратный реверс
    public static int[] reverseBack(int[] arr) {
        int[] resultingArray = new int[arr.length];
        int positionCounter = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            resultingArray[positionCounter] = arr[i];
            positionCounter++;
        }
        return resultingArray;
    }

    //Объединение
    public static int[] concat(int[] arr1, int[] arr2) {
        int[] resultingArray = new int[arr1.length + arr2.length];
        int positionCounter = 0;
        for (int i = 0; i < arr1.length; i++) {
            resultingArray[positionCounter] = arr1[i];
            positionCounter++;
        }
        for (int i = 0; i < arr2.length; i++) {
            resultingArray[positionCounter] = arr2[i];
            positionCounter++;
        }
        return resultingArray;
    }

    //Все вхождения
    public static int[] findAll(int[] arr, int x) {
        int insertionsCounter = 0;
        int postionCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                insertionsCounter++;
            }
        }
        int[] resultingArray = new int[insertionsCounter];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                resultingArray[postionCounter] = i;
                postionCounter++;
            }
        }
        return resultingArray;
    }

    //Удалить негатив
    public static int[] deleteNegative(int[] arr) {
        int positiveCounter = 0;
        int postionCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                positiveCounter++;
            }
        }
        int[] resultingArray = new int[positiveCounter];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                resultingArray[postionCounter] = arr[i];
                postionCounter++;
            }
        }
        return resultingArray;
    }

    //Добавление в массив
    public static int[] add(int[] arr, int x, int pos) {
        int[] resultingArray = new int[arr.length + 1];
        int postionCounter = 0;
        int arrPositionCounter = 0;
        for (int i = 0; i < resultingArray.length; i++) {
            resultingArray[pos] = x;
            if (i == pos) {
                postionCounter++;
            } else {
                resultingArray[postionCounter] = arr[arrPositionCounter];
                postionCounter++;
                arrPositionCounter++;
            }
        }
        return resultingArray;
    }

    //Добавление массива в массив
    public static int[] add(int[] arr, int[] ins, int pos) {
        int[] resultingArray = new int[arr.length + ins.length];
        int positionCounter = 0;
        int arrPositionCounter = 0;
        for (int i = 0; i <= resultingArray.length; i++) {
            if (positionCounter == pos) {
                for (int j = 0; j < ins.length; j++) {
                    resultingArray[positionCounter] = ins[j];
                    positionCounter++;
                    i++;
                }
            } else {
                resultingArray[positionCounter] = arr[arrPositionCounter];
                positionCounter++;
                arrPositionCounter++;
            }
        }
        return resultingArray;
    }
}

