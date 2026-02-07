package com.stepup.proj;

public class MainApplication {
    public static void main(String[] args) {
        Dot dot1 = new Dot(1,3);
        Dot dot2 = new Dot(1,3);
        Dot dot3 = new Dot(5,8);
        System.out.println("Dot1 is= "+dot1);
        System.out.println("Dot2 is= "+dot2);
        System.out.println("Dot3 is= "+dot3);
        System.out.println(dot1==dot2);
        System.out.println(dot1==dot3);
        System.out.println(dot2==dot3);
    }
}