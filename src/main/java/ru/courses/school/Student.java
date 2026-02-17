package ru.courses.school;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private List<Integer> grades;

    public Student(String name) {
        this(name, new ArrayList<>());
    }

    public Student(String name, List<Integer> grades) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("Имя Студента не может быть пустым!");
        } else {
            this.name = name;
        }
        for (int grade : grades) {
            addGrade(grade);
        }
        this.grades = grades;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void addGrade(int grade) {
        if ((grade < 2) || (grade > 5)) {
            throw new IllegalArgumentException("Оценки могут принимать значения только от 2 до 5!");
        } else {
            this.grades.add(grade);
        }
    }

    @Override
    public String toString() {
        return name + ":" + grades;
    }
}



