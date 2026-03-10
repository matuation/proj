package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.courses.edu.Student;
import ru.courses.edu.StudentRepository;

import static org.mockito.Mockito.when;

public class TestsStudent {


    @Test
    @DisplayName("Тест заглушки addGrade false")
    public void successfulStudentAddGradeMockFalse() {
        Student stud = new Student("Alexey");
        int studGrade = 5;
        StudentRepository repo = Mockito.mock(StudentRepository.class);
        when(repo.addGrade(Mockito.anyInt())).thenReturn(false);
        stud.setRepo(repo);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                stud.addGrade(studGrade));
    }

    @Test
    @DisplayName("Тест заглушки addGrade true")
    public void successfulStudentAddGradeMockTrue() {
        Student stud = new Student("Alexey");
        int studGrade = 5;
        StudentRepository repo = Mockito.mock(StudentRepository.class);
        when(repo.addGrade(Mockito.anyInt())).thenReturn(true);
        stud.setRepo(repo);
        stud.addGrade(studGrade);
        Assertions.assertEquals(studGrade, stud.getGrades().get(0));
    }

    @Test
    @DisplayName("Добавление корректной оценки студенту")

    public void successfulStudentAddGrade() {
        Student stud = new Student("Alexey");
        int studGrade = 5;
        stud.addGrade(studGrade);
        Assertions.assertEquals(studGrade, stud.getGrades().get(0));
    }

    @Test
    @DisplayName("Сравнение переменных у студентов")
    public void successfulStudentValuesCompareAsObject() {
        Student stud = new Student("Alexey");
        Student stud2 = new Student("Alexey");
        int studGrade = 5;
        stud.addGrade(studGrade);
        stud2.addGrade(studGrade);
        Assertions.assertTrue(stud.equals(stud2));
    }

    @Test
    @DisplayName("Студент идентичен себе")
    public void successfulStudentCompareItself() {
        Student stud = new Student("Alexey");
        int studGrade = 5;
        stud.addGrade(studGrade);
        Assertions.assertEquals(stud, stud);
    }

    @Test
    @DisplayName("Студент не null")
    public void successfulStudentNotNull() {
        Student stud = new Student("Alexey");
        int studGrade = 5;
        stud.addGrade(studGrade);
        Assertions.assertNotNull(stud);
    }

    @Test
    @DisplayName("Класс студента")
    public void successfulStudentClass() {
        Student stud = new Student("Alexey");
        int studGrade = 5;
        stud.addGrade(studGrade);
        Assertions.assertNotSame(TestsStudent.class, stud.getClass());
    }

    @Test
    @DisplayName("Класс студента")
    public void successfulStudentHash() {
        Student stud = new Student("Alexey");
        int studGrade = 5;
        stud.addGrade(studGrade);
        Assertions.assertNotNull(stud.hashCode());
    }

    @Test
    @DisplayName("Сравнение переменных у студентов")
    public void successfulStudentToString() {
        String name = "Alexey";
        Student stud = new Student(name);
        int studGrade = 5;
        stud.addGrade(studGrade);
        Assertions.assertTrue(stud.toString().contains(name));
        Assertions.assertTrue(stud.toString().contains(studGrade + ""));
    }

//    @Test
//    @DisplayName("Сравнение студентов по одинаковому имени")
//    public void successfulStudentNamesCompare() {
//        Student stud= new Student("Alexey");
//        Student stud2 = new Student("Alexey");
//        int studGrade = 5;
//        stud.addGrade(studGrade);
//        stud2.addGrade(studGrade);
//        Assertions.assertTrue(stud.getName().equals(stud2.getName()));
//    }

    //    @Test
//    @DisplayName("Создание объекта Студент")
//    public void successfulStudentCreate() {
//        String name = "Alexey";
//        Student stud = new Student(name);
//        Assertions.assertEquals(stud.getName(), name);
//    }

//    @Test
//    @DisplayName("Изменение имени студента")
//    public void successfulStudentNameChange() {
//        String name = "Alexey";
//        String newName = "Alexander";
//        Student stud = new Student(name);
//        stud.setName(newName);
//        Assertions.assertEquals(stud.getName(), newName);
//    }

    @DisplayName("Добавление некорректной оценки студенту")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 6})
    public void negativeStudentAddGrade(int grades) {
        Student stud = new Student("Alexey");
        int studBadGrade = grades;
        Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(studBadGrade));
    }


    @Test
    @DisplayName("Добавление некорректной оценки студенту через получение списка оценок")
    public void negativeIncapsulationStudentAddGrade() {
        Student stud = new Student("Alexey");
        int studGrade = 5;
        int studBadGrade = -6;
        stud.addGrade(studGrade);
        stud.getGrades().add(studBadGrade);
        Assertions.assertEquals(1, stud.getGrades().size());
        Assertions.assertEquals(studGrade, stud.getGrades().get(0));
    }

    @Test
    @DisplayName("Студенты с одинаковыми параметрами не идентичны")
    public void negativeStudentCompareAsObject() {
        Student stud = new Student("Alexey");
        Student stud2 = new Student("Alexey");
        int studGrade = 5;
        int studBadGrade = 6;
        stud.addGrade(studGrade);
        stud2.addGrade(studGrade);
        stud2.getGrades().add(studBadGrade);
        Assertions.assertFalse(stud == stud2);
    }


}

