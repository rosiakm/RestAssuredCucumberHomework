package stepdefs.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecifications {
    public static RequestSpecification getRequestData(){
        return (new RequestSpecBuilder()
                .setBaseUri(System.getProperty("base_uri")))
                .setBasePath(System.getProperty("base_path"))
                .addHeader("Content-Type",System.getProperty("content_type"))
                .build();
    }

    public static RequestSpecification getRequestDataWithPathParam(int id){
        return (new RequestSpecBuilder()
                .setBaseUri(System.getProperty("base_uri")))
                .setBasePath(System.getProperty("base_path"))
                .addHeader("Content-Type",System.getProperty("content_type"))
                .addParam("id", id)
                .build();
    }
}
