package stepdefs.base;

import io.cucumber.java.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.YamlProvider;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class TestBase {
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    public static void setup(){
        YamlProvider yamlProvider = YamlProvider.getInstance();
        log.info(">>>>>>Yaml Instance has been set<<<<<<<");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        log.info(">>>>>>Request/Response logs have been set<<<<<<<");
    }
}
