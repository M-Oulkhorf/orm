package sio.projet.orm.api.model;

import java.time.LocalDate;

public record FestivalCreationRequest(String libelle, String ville, LocalDate date, Double tarif) {
}
