package com.stepup.proj;

import java.util.ArrayList;

public class Student {
    private final String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this(name, new ArrayList<>());
    }
    public Student(String name, ArrayList<Integer> grades) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("Имя Студента не может быть пустым!");
        } else {
            this.name = name;
        }
        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            if ((grade < 2) || (grade > 5)) {
                throw new IllegalArgumentException("Оценки могут принимать значения только от 2 до 5!");
            }
        }
        this.grades = grades;
    }
    public ArrayList<Integer> getGrades() {
        return new ArrayList<>(grades);
    }
    public void setGrades(ArrayList<Integer> grades) {
        ArrayList<Integer> oldGrades = this.getGrades();
        if (oldGrades.size() > grades.size()) {
            throw new IllegalArgumentException("Нельзя удалить оценки!");
        }
        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            if ((grade < 2) || (grade > 5)) {
                throw new IllegalArgumentException("Оценки могут принимать значения только от 2 до 5!");
            }

        }
        this.grades = grades;
    }
    @Override
    public String toString() {
        return name + ":" + grades;
    }
}


