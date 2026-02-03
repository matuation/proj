package com.stepup.proj;

public class CycleMethods {
    public static String listNums(int x) {
        String results = "";
        for (int i = 0; i <= x; i++) {
            results += i + " ";
        }
        return results;
    }

    public static String reverseListNums(int x) {
        String results = "";
        for (int i = x; i >= 0; i--) {
            results += i + " ";
        }
        return results;
    }

    public static String chet(int x) {
        String results = "";
        for (int i = 0; i <= x; i += 2) {
            results += i + " ";
        }
        return results;
    }

    public static int pow(int x, int y) {
        int res = 1;
        for (int i = 0; i < y; i++) {
            res = res * x;
        }
        return res;
    }

    public static int numLen(long x) {
        int res = 0;
        long y = 0;
        while (x != 0) {
            y = x / 10;
            x = y;
            res++;
        }
        return res;
    }

    public static boolean equalNum(int x) {
        boolean res = true;
        int del = x % 10;
        while (x > 9) {
            x = x / 10;
            if (x % 10 != del) {
                res = true;
            } else {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void square(int x) {
        int a = 0;
        while (a < x) {
            int b = 0;
            while (b < x) {
                System.out.print("*");
                b++;
            }
            System.out.println();
            a++;
        }
    }

    public static void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            int count = i;
            for (int j = 0; j < count; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = x; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void guessGame() {
        int randomNum = 3;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("What number am I thinking (0 to 9)? :");
        int x = sc.nextInt();
        int i;
        for (i = 1; randomNum != x; i++) {
            if (x != randomNum) {
                System.out.println("No, try again");
                x = sc.nextInt();
            }
        }
        System.out.println("Yes, it`s " + randomNum);
        System.out.println("You tried " + i + " times!");
    }


}




