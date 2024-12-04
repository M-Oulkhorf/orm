package sio.projet.orm.service;

import sio.projet.orm.api.model.BandCreationRequest;
import sio.projet.orm.api.model.FestivalCreationRequest;
import sio.projet.orm.repositorymodel.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandService {
    private final BandRepository bandRepository;
    private final FestivalRepository festivalRepository;
    private final MusicianRepository musicianRepository;

    public BandService(BandRepository bandRepository, FestivalRepository festivalRepository, MusicianRepository musicianRepository) {
        this.bandRepository = bandRepository;
        this.festivalRepository = festivalRepository;
        this.musicianRepository = musicianRepository;
    }

    // Crée un festival à partir d'une requête
    public Festival createFestival(FestivalCreationRequest festivalCreationRequest) {
        return festivalRepository.save(new Festival(festivalCreationRequest.libelle(), festivalCreationRequest.ville(), festivalCreationRequest.date(), festivalCreationRequest.tarif()));
    }

    // Ajoute des groupes à un festival existant
    @Transactional
    public Optional<Festival> addBandsToFestival(long festivalId, List<Long> bandIds) {
        return festivalRepository.findById(festivalId)
                .map(festival -> {
                    festival.setBands(bandRepository.findAllById(bandIds));
                    return festivalRepository.save(festival);
                });
    }

    // Crée un groupe à partir d'une requête
    public Band createBand(BandCreationRequest bandCreationRequest) {
        return bandRepository.save(new Band(bandCreationRequest.band_name()));
    }

    // Récupère un groupe par son ID
    public Optional<Band> getBand(final long id) {
        return bandRepository.findById(id);
    }

    // Ajoute des musiciens à un groupe existant
    @Transactional
    public Optional<Band> addMusiciansToBand(long bandId, List<Long> musicianIds) {
        return bandRepository.findById(bandId).map(band -> {
            List<Musician> musicians = musicianRepository.findAllById(musicianIds);
            band.setMusicians(musicians);
            return bandRepository.save(band);
        });
    }

    // Met à jour un groupe existant
    public Band updateBand(Band band) {
        return bandRepository.save(band);
    }

    // Supprime un groupe par son ID
    public void deleteBand(Long id) {
        bandRepository.deleteById(id);
    }
}
