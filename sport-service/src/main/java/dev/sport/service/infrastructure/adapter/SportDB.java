package dev.sport.service.infrastructure.adapter;

import dev.sport.service.domain.repository.SportRepositoryInterface;
import dev.sport.service.infrastructure.model.entites.Sport;
import dev.sport.service.infrastructure.model.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SportDB implements SportRepositoryInterface {
    final SportRepository sportRepository;

    @Autowired
    public SportDB(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    @Override
    public Sport save(Sport sport) {
        return sportRepository.save(sport);
    }

    @Override
    public Optional<Sport> findBySportName(String name) {
        return sportRepository.findByName(name);
    }

    @Override
    public Optional<Sport> findById(UUID id) {
        return sportRepository.findById(id);
    }

    @Override
    public void delete(Sport sport) {
        sportRepository.delete(sport);
    }

    @Override
    public List<Sport> findAll() {
        return sportRepository.findAll();
    }

}
