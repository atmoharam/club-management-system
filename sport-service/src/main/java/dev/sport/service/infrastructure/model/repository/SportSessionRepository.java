package dev.sport.service.infrastructure.model.repository;

import dev.sport.service.infrastructure.model.entites.Sport;
import dev.sport.service.infrastructure.model.entites.SportSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public interface SportSessionRepository extends JpaRepository<SportSession, UUID> {
    List<SportSession> findAllBySport(Sport sport);
    Optional<SportSession> findById(UUID sportSessionId);
    List<SportSession> findAllByTrainerId(UUID trainerId);



}
