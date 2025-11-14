package ie.atu.using_jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final PersonRepository personRepository;

    public DataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Address address1 = new Address("h91534", "galway");
        Person testData = new Person("Paul", "paul@atu.ie", "1234", "lecturer", "electronics", address1);

        Address address2 = new Address("h914567", "galway");
        Person testData2 = new Person("John", "john@atu.ie", "1235", "student", "electronics", address1);

        personRepository.save(testData);
        personRepository.save(testData2);
    }
}
