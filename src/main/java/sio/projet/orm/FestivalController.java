package sio.projet.orm;

import org.springframework.web.bind.annotation.*;
import sio.projet.orm.api.model.FestivalCreationRequest;
import sio.projet.orm.repositorymodel.Festival;
import sio.projet.orm.service.BandService;

@RestController
@RequestMapping("/api/v1/festivals")
public class FestivalController {
    private final BandService bandService;

    public FestivalController(BandService bandService) {
        this.bandService = bandService;
    }


    @PostMapping
    public Festival createFestival(@RequestBody FestivalCreationRequest festivalCreationRequest) {
        return bandService.createFestival(festivalCreationRequest);
    }
}