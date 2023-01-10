package providers;

import models.Student;
import net.datafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentBuilder {
    private static final Logger log = LoggerFactory.getLogger(StudentBuilder.class);
    public static Faker faker = new Faker();

    public static Student createStudent(){
        return Student.builder()
                .first_name(faker.name().firstName())
                .middle_name(faker.name().firstName())
                .last_name(faker.name().lastName())
                .date_of_birth(faker.date().birthday("dd/MM/YYYY"))
                .build();
    }
}
