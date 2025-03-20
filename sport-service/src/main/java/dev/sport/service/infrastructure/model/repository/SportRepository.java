package dev.sport.service.infrastructure.model.repository;

import dev.sport.service.infrastructure.model.entites.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public interface SportRepository extends JpaRepository<Sport, UUID> {
    Optional<Sport> findByName(String name);
    Optional<Sport> findById(UUID id);
}
