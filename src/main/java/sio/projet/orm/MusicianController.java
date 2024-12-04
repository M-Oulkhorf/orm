package sio.projet.orm;

import org.springframework.web.bind.annotation.*;
import sio.projet.orm.api.model.CreateMusicianRequest;
import sio.projet.orm.repositorymodel.Band;
import sio.projet.orm.repositorymodel.Musician;
import sio.projet.orm.service.MusicianService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/musicians")
public class MusicianController {
    private final MusicianService musicianService;

    public MusicianController(MusicianService musicianService) {
        this.musicianService = musicianService;
    }

    // Crée un nouveau musicien à partir d'une requête
    @PostMapping
    public Musician createMusician(@RequestBody CreateMusicianRequest createMusicianRequest, @RequestParam String instruments) {
        return musicianService.createMusician(createMusicianRequest, instruments);
    }

    // Récupère un musicien par son ID
    @GetMapping("/{id}")
    public Musician getMusician(@PathVariable long id) {
        return musicianService.getMusician(id).orElseThrow();
    }

    // Récupère tous les groupes associés à un musicien par son ID
    @GetMapping("/bands/{musicianId}")
    public List<Band> getBands(@PathVariable long musicianId) {
        return musicianService.getBandsByMusicianId(musicianId);
    }

    // Met à jour un musicien existant
    @PutMapping("/{id}")
    public Musician updateMusician(@PathVariable long id, @RequestBody CreateMusicianRequest createMusicianRequest) {
        return musicianService.updateMusician(id, createMusicianRequest);
    }

    // Supprime un musicien par son ID
    @DeleteMapping("/{id}")
    public void deleteMusician(@PathVariable long id) {
        musicianService.deleteMusician(id);
    }
}
