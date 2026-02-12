package ru.courses.school;

import java.util.ArrayList;

public class Student {
    private final String name;
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this(name, new ArrayList<>());
    }

    public Student(String name, ArrayList<Integer> grades) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("Имя Студента не может быть пустым!");
        } else {
            this.name = name;
        }
        for (int grade : grades) {
            addGrade(grade);
        }
        this.grades = new ArrayList<>(grades);
    }

    public ArrayList<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void addGrade(int grade) {
        if ((grade < 2) || (grade > 5)) {
            throw new IllegalArgumentException("Оценки могут принимать значения только от 2 до 5!");
        } else {
            this.grades.add(grade);
        }
        this.grades = new ArrayList<>(grades);
    }

    @Override
    public String toString() {
        return name + ":" + grades;
    }
}



