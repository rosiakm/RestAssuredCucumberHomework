package utils;

import io.restassured.response.Response;
import models.Student;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public Response sendGETStudentRequestWithParam(Parameters parameters){
        return given()
                .baseUri(parameters.getBASE_URI())
                .basePath(parameters.getBASE_PATH())
                .contentType(parameters.getCONTENT_TYPE())
                .param("id",parameters.getPARAM()).
        when()
                .get();
    }
    public Response sendPOSTStudentRequest(Parameters parameters, Student student){
        return given()
                .baseUri(parameters.getBASE_URI())
                .basePath(parameters.getBASE_PATH())
                .contentType(parameters.getCONTENT_TYPE())
                .body(student).
        when()
                .post();
    }
    public Response sendPUTStudentRequest(Parameters parameters, Student student){
        return given()
                .baseUri(parameters.getBASE_URI())
                .basePath(parameters.getBASE_PATH())
                .contentType(parameters.getCONTENT_TYPE())
                .body(student).
        when()
                .put();
    }
    public Response sendDELETEStudentRequest(Parameters parameters){
        return given()
                .baseUri(parameters.getBASE_URI())
                .basePath(parameters.getBASE_PATH())
                .contentType(parameters.getCONTENT_TYPE())
                .pathParam("id",parameters.getPARAM()).
        when()
                .delete();
    }
}
