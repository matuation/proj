package edu;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.is;


public class ApiStudentTests {

    @AfterEach
    public void cleanStudents() {
        deleteStudents();
    }

    String studentBasic = """
            {
            	"id": 1,
            	"name": "Zhorik",
            	"marks": [1,2,3,4,5]
            }""";

    String studentUpdated = """
            {
            	"id": 1,
            	"name": "George",
            	"marks": [1,2,3,4,5]
            }""";

    String studentNoId = """
            {
            	"id": null,
            	"name": "Gustavo",
            	"marks": [1,2,3,4,5]
            }""";

    String studentNoName = """
            {
            	"id": "1",
            	"marks": [1,2,3,4,5]
            }""";

    String studentNoMarks = """
            {
            	"id": "",
            	"name": "Jerry",
            	"marks": []
            }""";

    String studentBestMarks = """
            {
            	"id": "3",
            	"name": "Henry",
            	"marks": [5,5,5,5,5]
            }""";

    String studentBestMarksFriend = """
            {
            	"id": "4",
            	"name": "Lucian",
            	"marks": [5,5,5,5,5]
            }""";


    String studentBestAndMostMarks = """
            {
            	"id": "5",
            	"name": "Boris",
            	"marks": [5,5,5,5,5,5]
            }""";

    JsonPath jsonBasicStudent = new JsonPath(studentBasic);

    int failStudentId = -1;

    @Test
    @DisplayName("1 Получить существующего студента")
    public void getExistingStudent() {
        addStudent(studentBasic);

        JsonPath response = RestAssured.given()
                .baseUri("http://localhost:8080/student/" + jsonBasicStudent.get("id"))
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .jsonPath();

        Assertions.assertEquals("Zhorik", response.get("name").toString());

    }

    @Test
    @DisplayName("2 Получить несуществующего студента")
    public void getNotExistingStudent() {
        RestAssured.given()
                .baseUri("http://localhost:8080/student/" + failStudentId)
                .when()
                .get()
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("3 Создать несуществующего студента со свободным id")
    public void addNotExistingStudent() {
        RestAssured.given().log().all()
                .baseUri("http://localhost:8080/student/")
                .contentType(ContentType.JSON)
                .body(studentBasic)
                .when()
                .post()
                .then()
                .statusCode(201);

    }

    @Test
    @DisplayName("4 Обновить существующего студента")
    public void updateExistingStudent() {

        addStudent(studentBasic);

        RestAssured.given().
                log().
                all()
                .baseUri("http://localhost:8080/student/")
                .contentType(ContentType.JSON)
                .body(studentUpdated)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(201);

    }

    @Test
    @DisplayName("5 Создать студента с автоприсвоением id")
    public void addNotExistingStudentWithNewId() {
        RestAssured.given().log().all()
                .baseUri("http://localhost:8080/student/")
                .contentType(ContentType.JSON)
                .body(studentNoId)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(201);

    }

    @Test
    @DisplayName("6 Создать студента без имени")
    public void addStudentWithoutName() {
        RestAssured.given().log().all()
                .baseUri("http://localhost:8080/student/")
                .contentType(ContentType.JSON)
                .body(studentNoName)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(400);

    }

    @Test
    @DisplayName("7 Удалить существующего студента")
    public void deleteExistingStudent() {
        addStudent(studentBasic);

        RestAssured.given()
                .baseUri("http://localhost:8080/student/" + jsonBasicStudent.get("id"))
                .when()
                .delete()
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    @DisplayName("8 Удалить не существующего студента")
    public void deleteNotExistingStudent() {
        RestAssured.given()
                .baseUri("http://localhost:8080/student/" + failStudentId)
                .when()
                .delete()
                .then()
                .log()
                .all()
                .statusCode(404);
    }

    @Test
    @DisplayName("9 Получить топ из несуществующих студентов")
    public void getNotExistingTopStudent() {
        RestAssured.given()
                .baseUri("http://localhost:8080/topStudent")
                .when()
                .get()
                .then()
                .body(is(emptyOrNullString()))
                .statusCode(200);
    }

    @Test
    @DisplayName("10 Получить топ из существующих студентов без оценок")
    public void getExistingTopStudentWithoutMarks() {
        addStudent(studentNoMarks);
        addStudent(studentNoMarks);

        RestAssured.given()
                .baseUri("http://localhost:8080/topStudent")
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all()
                .body(is(emptyOrNullString()))
                .statusCode(200);

    }

    @Test
    @DisplayName("11 Получить топ студента")
    public void getExistingTopStudent() {
        addStudent(studentBasic);
        addStudent(studentBestMarks);
        addStudent(studentBestAndMostMarks);
        addStudent(studentNoMarks);

        JsonPath response = RestAssured.given()
                .baseUri("http://localhost:8080/topStudent")
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .jsonPath();

        Assertions.assertEquals("[Boris]", response.get("name").toString());

    }

    @Test
    @DisplayName("12 Получить топ студентов")
    public void getExistingTopStudents() {
        addStudent(studentBestMarks);
        addStudent(studentBasic);
        addStudent(studentBestMarksFriend);
        addStudent(studentNoMarks);

        JsonPath response = RestAssured.given()
                .baseUri("http://localhost:8080/topStudent")
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .jsonPath();

Assertions.assertEquals("[Henry, Lucian]", response.get("name").toString());
    }

    public void addStudent(String body) {
        RestAssured.given()
                .baseUri("http://localhost:8080/student/")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(body)
                .when()
                .post()
        ;
    }

    public void deleteStudents() {
        for (int i = 1; i <= 100; i++) {
            if (studentFinder(i)) {
                studentKiller(i);
            }
        }
    }

    public boolean studentFinder(int i) {
        int statusCode = RestAssured.given()
                .baseUri("http://localhost:8080/student/" + i)
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .statusCode();
        return statusCode == 200;
    }

    public void studentKiller(int i) {
        RestAssured.given()
                .baseUri("http://localhost:8080/student/" + i)
                .log()
                .all()
                .when()
                .delete()
                .then()
                .log()
                .all();
    }


//            RestAssured.given()
//                    .baseUri("http://localhost:8080/student/" + jsonBasicStudent.get("id"))
//            .when()
//                .delete()
//                .then()
//                .log()
//                .all()
//                .statusCode(200);
//
}

