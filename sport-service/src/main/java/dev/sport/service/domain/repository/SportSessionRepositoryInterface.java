package dev.sport.service.domain.repository;

import dev.sport.service.infrastructure.model.entites.SportSession;

public interface SportSessionRepositoryInterface {

    SportSession save(SportSession sportSession);
}
