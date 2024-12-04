package sio.projet.orm.repositorymodel;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FESTIVAL")
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle")
    private String libelle;
    @Column(name = "ville")
    private String ville;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "tarif")
    private Double tarif;

    @ManyToMany
    @JoinTable(
            name = "BAND_FESTIVAL",
            joinColumns = @JoinColumn(name = "festival_id"),
            inverseJoinColumns = @JoinColumn(name = "band_id")
    )
    private List<Band> bands = new ArrayList<>();

    public Festival(String libelle, String ville, LocalDate date, Double tarif) {
        this.libelle = libelle;
        this.ville = ville;
        this.date = date;
        this.tarif = tarif;
        this.bands = new ArrayList<>();
    }

    public Festival() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }

    public List<Band> getBands() {
        return bands;
    }

    public void setBands(List<Band> bands) {
        this.bands = bands;
    }
}
