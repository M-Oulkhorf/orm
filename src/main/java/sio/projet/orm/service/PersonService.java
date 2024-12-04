package sio.projet.orm.service;

import org.springframework.stereotype.Service;
import sio.projet.orm.repositorymodel.Person;
import sio.projet.orm.repositorymodel.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Crée une nouvelle personne
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    // Récupère toutes les personnes
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Récupère une personne par son ID
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }
}

