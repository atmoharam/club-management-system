package dev.sport.service.application;

import dev.sport.service.infrastructure.adapter.SportDB;
import dev.sport.service.infrastructure.model.entites.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public void deleteSport(UUID id) {
        Sport sport = SportDB.findById(id).orElse(null);
        if (sport != null) {
            SportDB.delete(sport);
        }
    }

    public Sport updateSport( String name, String description) {
        Sport sport = SportDB.findBySportName(name).orElse(null);
        if (sport != null) {
            sport.setName(name);
            sport.setDescription(description);
            return SportDB.save(sport);
        }
        return null;
    }

    public List<Sport> getAllSports() {
        return SportDB.findAll();
    }

    public Optional<Sport> getSportById(UUID id) {
        return SportDB.findById(id);
    }

    public Optional<Sport> getSportByName(String name) {
        return SportDB.findBySportName(name);
    }


}
