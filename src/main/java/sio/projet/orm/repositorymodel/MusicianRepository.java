package sio.projet.orm.repositorymodel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicianRepository extends JpaRepository<Musician, Long> {
    // Récupère tous les groupes associés à un musicien par son ID
    @Query("select b from Band b join b.musicians m where m.id = ?1")
    List<Band> findAllBandsByMusicianId(Long musicianId);
}