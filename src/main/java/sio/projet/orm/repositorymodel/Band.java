package sio.projet.orm.repositorymodel;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BAND")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "band_name", nullable = false)
    private String bandName;

    @ManyToMany
    @JoinTable(
            name = "BAND_MUSICIAN",
            joinColumns = @JoinColumn(name = "band_id"),
            inverseJoinColumns = @JoinColumn(name = "musician_id")
    )
    private List<Musician> musicians = new ArrayList<>();

    public Band() {
    }

    public Band(String bandName) {
        this.bandName = bandName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public List<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Musician> musicians) {
        this.musicians = musicians;
    }

    public void addMusician(Musician musician) {
        this.musicians.add(musician);
        musician.getBands().add(this);
    }

    public void removeMusician(Musician musician) {
        this.musicians.remove(musician);
        musician.getBands().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return id != null && id.equals(band.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}


