package ie.atu.using_jpa;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService service;
    public PersonController(PersonService service) { this.service = service; }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@Valid @RequestBody Person person) {
        return service.create(person);
    }
    @GetMapping
    public List<Person> all() { return service.findAll(); }
    @GetMapping("/{id}")
    public Person byEmployeeId(@PathVariable String id) {
        return service.findByEmployeeId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Person update(@PathVariable String id, @Valid @RequestBody Person person){
        return service.updatePersonById(id, person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.deleteByEmployeeId(id);
    }
}
