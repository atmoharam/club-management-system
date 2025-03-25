package dev.sport.service.domain.repository;

import dev.sport.service.infrastructure.model.entites.Sport;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SportRepositoryInterface {
    public Sport save(Sport sport);
    public Optional<Sport> findBySportName(String name);
    public Optional<Sport> findById(UUID id);
    public void delete(Sport sport);
    public List<Sport> findAll();
}
