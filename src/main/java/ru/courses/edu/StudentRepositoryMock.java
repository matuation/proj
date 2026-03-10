package ru.courses.edu;

public class StudentRepositoryMock implements StudentRepository{
    @Override
    public  boolean addGrade(int grade) {
        boolean response;
        if ((grade < 2) || (grade > 5)) {
            return response = false;

        } else {
            return response = true;

        }
    }

    @Override
    public int raiting() {
        return 10;
    }
}
