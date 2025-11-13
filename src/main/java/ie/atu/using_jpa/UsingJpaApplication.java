package ie.atu.using_jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsingJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsingJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PersonRepository repo) {
        return args -> {
            repo.save(Person.builder()
                    .name("John")
                    .email("john@atu.ie")
                    .employeeId("12345")
                    .position("Lecturer")
                    .department("Engineering")
                    .admin(false)
                    .build());

            repo.save(Person.builder()
                    .name("Matt")
                    .email("matt@atu.ie")
                    .employeeId("56789")
                    .position("Student")
                    .department("Engineering")
                    .admin(false)
                    .build());
        };
    }
}
