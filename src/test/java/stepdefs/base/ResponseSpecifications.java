package stepdefs.base;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class ResponseSpecifications {
    public static ResponseSpecification getResponseData(){
        return (new ResponseSpecBuilder()
                .expectContentType(System.getProperty("content_type"))
                .expectResponseTime(Matchers.lessThan(8000L))
                .build());
    }
}
