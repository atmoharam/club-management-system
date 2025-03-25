package dev.sport.service.domain.repository;

import dev.sport.service.infrastructure.model.entites.SportSession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SportSessionRepositoryInterface {

    SportSession save(SportSession sportSession);
     Optional<SportSession> getById(UUID sessionId);
    List<SportSession> getSessionsBySportName(String sportName);
    List<SportSession> getSessionsByTrainerId(UUID trainerId);
}

