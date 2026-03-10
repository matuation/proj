package ru.courses.edu;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Student {

    @Setter
    private StudentRepository repo;
    @Getter
    @Setter
    private String name;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void setRepo(StudentRepository repo) {
        this.repo = repo;
    }

    @SneakyThrows
    public void addGrade(int grade) {
        if(!repo.addGrade(grade)) {
            throw new IllegalArgumentException("Оценки могут принимать значения только от 2 до 5!");
        }
        else {
            grades.add(grade);
        }
    }

    @SneakyThrows
    public int raiting() {
        return repo.raiting();
    }
}