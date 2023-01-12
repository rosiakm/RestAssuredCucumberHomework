package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import models.Student;
import models.StudentResponse;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.RequestBuilder;
import providers.StudentBuilder;
import utils.ApiClient;
import utils.Parameters;

import static stepdefs.base.ResponseSpecifications.getResponseData;

public class StudentDetailsE2ETest {
    private static final Logger log = LoggerFactory.getLogger(StudentDetailsE2ETest.class);
    private Student student;
    private int id;
    private StudentResponse response;
    private final ApiClient client = new ApiClient();
    Parameters parameters = RequestBuilder.setParameters();

    public StudentDetailsE2ETest() {
    }

    @Given("Send POST to register new student")
    public void sendPOSTToRegisterNewStudent() {
        student = StudentBuilder.createStudent();
        log.info(">>>>>NEW STUDENT HAS BEEN CREATED<<<<<");
        id = client.sendPOSTStudentRequest(parameters, student).
        then()
                .statusCode(201)
                .spec(getResponseData())
                .extract()
                .path("id");
    }

    @When("Send GET to check if student exists")
    public void sendGETToCheckIfStudentExists() {
        parameters.setPARAM(id);
        response = client.sendGETStudentRequestWithParam(parameters).
        then()
                .statusCode(200)
                .spec(getResponseData())
                .extract().as(new TypeRef<StudentResponse>() {
                });
        Assertions.assertThat(response.getStatus()).isEqualTo(System.getProperty("response_status"));
        Assertions.assertThat(response.getData().getFirst_name()).isEqualTo(student.getFirst_name());
    }

    @And("Send PUT to update student data")
    public void sendPUTToUpdateStudentData() {
        student.setMiddle_name("John");
        response = client.sendPUTStudentRequest(parameters, student).
        then()
                .statusCode(200)
                .spec(getResponseData())
                .extract().path("middle_name");
        Assertions.assertThat(response.getData().getMiddle_name()).isEqualTo(student.getMiddle_name());
    }

    @And("Send GET to check if student data updated")
    public void sendGETToCheckIfStudentDataUpdated() {
        response = client.sendGETStudentRequestWithParam(parameters).
        then()
                .statusCode(200)
                .spec(getResponseData())
                .extract().as(new TypeRef<StudentResponse>() {
                });
        Assertions.assertThat(response.getData().getMiddle_name()).isEqualTo(student.getMiddle_name());
    }
    @And("Send DELETE to remove student")
    public void sendDELETEToRemoveStudent() {
        client.sendDELETEStudentRequest(parameters).
        then()
                .statusCode(200)
                .spec(getResponseData());
    }
    @Then("Send GET to check if student does not exist anymore")
    public void sendGETToCheckIfStudentDoesNotExistAnymore() {
        client.sendGETStudentRequestWithParam(parameters).
        then()
                .statusCode(404);
    }
}
