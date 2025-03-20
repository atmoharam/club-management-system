package dev.sport.service.application;

import dev.sport.service.infrastructure.adapter.SportDB;
import dev.sport.service.infrastructure.model.entites.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportManagementUseCase {

    private final SportDB SportDB;
    @Autowired
    public SportManagementUseCase(SportDB SportDB) {
        this.SportDB = SportDB;
    }

    public Sport createSport(String name, String description) {
        Sport sport = SportDB.findBySportName(name).orElse(null);
        if (sport == null) {
            sport = Sport.builder()
                    .name(name)
                    .description(description)
                    .build();
            sport = SportDB.save(sport);
        }
        return sport;
    }


}
