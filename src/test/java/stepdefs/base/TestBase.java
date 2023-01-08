package stepdefs.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.YamlProvider;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    private static Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    public static void setup(){
        YamlProvider yamlProvider = YamlProvider.getInstance();
        log.info(">>>>>>Yaml Instance has been set<<<<<<<");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        log.info(">>>>>>Request/Response logs have been set<<<<<<<");
    }

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

    public static ResponseSpecification getResponseData(){
        return (new ResponseSpecBuilder()
                .expectContentType(System.getProperty("content_type"))
                .expectResponseTime(Matchers.lessThan(5000L))
                .build());
    }
}
