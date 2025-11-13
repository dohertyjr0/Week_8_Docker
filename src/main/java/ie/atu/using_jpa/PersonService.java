package ie.atu.using_jpa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repo;
    public PersonService(PersonRepository repo) { this.repo = repo; }
    public Person create(Person p) { return repo.save(p); }
    public List<Person> findAll() { return repo.findAll(); }
    public Person findByEmployeeId(String id) {
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }
    public Person updatePersonById(String id, Person p){
        Person existing = repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));

        existing.setName(p.getName());
        existing.setEmail(p.getEmail());
        existing.setPosition(p.getPosition());
        existing.setDepartment(p.getDepartment());
        existing.setAdmin(p.isAdmin());

        return repo.save(existing);
    }

    public void deleteByEmployeeId(String id){
        Person person = repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
        repo.delete(person);
    }
}
