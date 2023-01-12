package utils;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Parameters {
    private String BASE_URI;
    private String BASE_PATH;
    private String CONTENT_TYPE;
    private int PATH_PARAM;
}
