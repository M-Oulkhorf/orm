package sio.projet.orm;

import org.springframework.web.bind.annotation.*;
import sio.projet.orm.repositorymodel.Person;
import sio.projet.orm.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Crée une nouvelle personne
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    // Récupère toutes les personnes
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // Récupère une personne par son ID
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id).orElseThrow();
    }
}
