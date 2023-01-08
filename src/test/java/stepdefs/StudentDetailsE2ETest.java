package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import models.Student;
import models.StudentResponse;
import org.assertj.core.api.Assertions;
import providers.StudentBuilder;
import stepdefs.base.TestBase;

import static io.restassured.RestAssured.given;

public class StudentDetailsE2ETest extends TestBase {
    private Student student;
    private int id;
    private StudentResponse response;
    @Given("The new student has been registered")
    public void the_new_student_has_been_registered() {
        student = StudentBuilder.createStudent();
        id = given()
                .spec(getRequestData())
                .body(student).
        when()
                .post().
        then()
                .statusCode(201)
                .extract()
                .path("id");
    }

    @When("The Students details are saved")
    public void the_students_details_are_saved() {
        response = given()
                .spec(getRequestDataWithPathParam(id)).
        when()
                .get("/{id}").
        then()
                .statusCode(200)
                .spec(getResponseData())
                .extract().as(new TypeRef<StudentResponse>(){});
        Assertions.assertThat(response.getStatus()).isEqualTo(System.getProperty("response_status"));
        Assertions.assertThat(response.getData().getFirst_name()).isEqualTo(student.getFirst_name());
    }

    @When("The Students middle name has been updated")
    public void the_students_middle_name_has_been_updated() {
        student.setMiddle_name("John");
        response = given()
                .spec(getRequestDataWithPathParam(id))
                .body(student).
        when()
                .put("/{id}").
        then()
                .statusCode(200)
                .spec(getResponseData())
                .extract().path("middle_name");
        Assertions.assertThat(response.getData().getMiddle_name()).isEqualTo(student.getMiddle_name());
    }

    @When("Updates are saved")
    public void updates_are_saved() {
        response = given()
                .spec(getRequestDataWithPathParam(id)).
        when()
                .get("/{id}").
        then()
                .statusCode(200)
                .spec(getResponseData())
                .extract().as(new TypeRef<StudentResponse>(){});
        Assertions.assertThat(response.getData().getMiddle_name()).isEqualTo(student.getMiddle_name());
    }

    @When("The Student has been deleted")
    public void the_student_has_been_deleted() {
        given()
                .spec(getRequestDataWithPathParam(id)).
        when()
                .delete("/{id}").
        then()
                .statusCode(200)
                .spec(getResponseData());
    }

    @Then("The Student does not exist anymore")
    public void the_student_does_not_exist_anymore() {
        given()
                .spec(getRequestDataWithPathParam(id)).
        when()
                .get("/{id}").
        then()
                .statusCode(404);
    }
}