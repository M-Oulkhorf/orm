package sio.projet.orm;

import org.springframework.web.bind.annotation.*;
import sio.projet.orm.api.model.BandCreationRequest;
import sio.projet.orm.api.model.FestivalCreationRequest;
import sio.projet.orm.repositorymodel.Band;
import sio.projet.orm.repositorymodel.Festival;
import sio.projet.orm.service.BandService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bands")
public class BandController {
    private final BandService bandService;

    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    // Crée un nouveau groupe
    @PostMapping
    public Band createBand(@RequestBody BandCreationRequest bandCreationRequest) {
        return bandService.createBand(bandCreationRequest);
    }

    // Récupère un groupe par son ID
    @GetMapping("/{id}")
    public Band getBand(@PathVariable long id) {
        return bandService.getBand(id)
                .orElseThrow(() -> new RuntimeException("Band not found with ID: " + id));
    }

    // Associe des groupes à un festival existant
    @PatchMapping("/{bandId}/festivals/{festivalId}")
    public Optional<Festival> addBandsToFestival(@PathVariable long festivalId, @RequestBody List<Long> bandIds) {
        return bandService.addBandsToFestival(festivalId, bandIds);
    }

    // Met à jour un groupe existant
    @PutMapping("/{id}")
    public Band updateBand(@PathVariable long id, @RequestBody BandCreationRequest bandCreationRequest) {
        Band band = bandService.getBand(id).orElseThrow();
        band.setBandName(bandCreationRequest.band_name());
        return bandService.updateBand(band);
    }

    // Supprime un groupe par son ID
    @DeleteMapping("/{id}")
    public void deleteBand(@PathVariable long id) {
        bandService.deleteBand(id);
    }
}
