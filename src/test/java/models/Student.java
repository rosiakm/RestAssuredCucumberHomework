package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;
}
