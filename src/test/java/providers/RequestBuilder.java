package providers;

import utils.Parameters;

public class RequestBuilder {
    public static Parameters setParameters(){
        return Parameters.builder()
                .BASE_URI(System.getProperty("base_uri"))
                .BASE_PATH(System.getProperty("base_path"))
                .CONTENT_TYPE(System.getProperty("content_type"))
                .build();
    }
}
