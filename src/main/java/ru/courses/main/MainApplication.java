package ru.courses.main;

import ru.courses.Cat;
import ru.courses.edu.Student;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;


public class MainApplication {
    public static void main(String[] args) {
        Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton",
                "Oleg", "Igor")));
        nullifier(cat);

        Student st= new Student("vasia");
        st.addGrade(5);
        st.getGrades().add(-20);
        System.out.println(st);
    }

    private static void nullifier(Object obj) {
        Field[] objFields = obj.getClass().getDeclaredFields();
        for (Field field : objFields) {
            field.setAccessible(true);
            if (!(field.getType().equals(int.class))) {
                try {
                    field.set(obj, null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(obj);
    }


}




