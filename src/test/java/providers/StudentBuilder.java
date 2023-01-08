package providers;

import models.Student;
import net.datafaker.Faker;

public class StudentBuilder {
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
