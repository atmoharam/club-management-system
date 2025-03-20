package dev.sport.service.domain.repository;

import dev.sport.service.infrastructure.model.entites.Sport;
import dev.sport.service.infrastructure.model.entites.UserSportFollowing;

import java.util.Optional;
import java.util.UUID;

public interface SportRepositoryInterface {
    public Sport save(Sport sport);
    public Optional<Sport> findBySportName(String name);
    public Optional<Sport> findById(UUID id);
}
