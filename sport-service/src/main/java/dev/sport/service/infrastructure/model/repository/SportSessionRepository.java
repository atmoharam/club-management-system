package dev.sport.service.infrastructure.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface SportSessionRepository extends JpaRepository<SportSession, UUID> {
}
