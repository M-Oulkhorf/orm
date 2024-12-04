package sio.projet.orm.service;

import org.springframework.stereotype.Service;
import sio.projet.orm.api.model.CreateMusicianRequest;
import sio.projet.orm.repositorymodel.*;

import java.util.List;
import java.util.Optional;

@Service
public class MusicianService {
    private final MusicianRepository musicianRepository;
    private final PersonRepository personRepository;

    public MusicianService(MusicianRepository musicianRepository, PersonRepository personRepository) {
        this.musicianRepository = musicianRepository;
        this.personRepository = personRepository;
    }

    // Crée un musicien à partir d'une requête et d'une chaîne d'instruments
    public Musician createMusician(CreateMusicianRequest createMusicianRequest, String instruments) {
        Musician musician = mapToMusician(createMusicianRequest);
        musician.setInstruments(instruments);
        return musicianRepository.save(musician);
    }

    // Récupère un musicien par son ID
    public Optional<Musician> getMusician(long id) {
        return musicianRepository.findById(id);
    }

    // Mappe une requête de création à un objet Musician
    private Musician mapToMusician(CreateMusicianRequest createRequest) {
        Musician musician = new Musician();
        Person person = new Person();
        person.setFirstName(createRequest.first_name());
        person.setLastName(createRequest.last_name());
        person.setEmail(createRequest.email());
        person.setAge(createRequest.age());
        personRepository.save(person);
        musician.setPerson(person);
        return musician;
    }

    // Récupère tous les groupes associés à un musicien par son ID
    public List<Band> getBandsByMusicianId(long musicianId) {
        return musicianRepository.findAllBandsByMusicianId(musicianId);
    }

    // Met à jour un musicien existant
    public Musician updateMusician(Long id, CreateMusicianRequest createMusicianRequest) {
        Musician musician = musicianRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Musician not found with id: " + id));
        Person person = musician.getPerson();
        person.setFirstName(createMusicianRequest.first_name());
        person.setLastName(createMusicianRequest.last_name());
        person.setEmail(createMusicianRequest.email());
        person.setAge(createMusicianRequest.age());
        personRepository.save(person);
        return musicianRepository.save(musician);
    }

    // Supprime un musicien par son ID
    public void deleteMusician(Long id) {
        musicianRepository.deleteById(id);
    }
}
