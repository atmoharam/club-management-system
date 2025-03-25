package dev.security.gate.service.domain.repository;

import dev.security.gate.service.infrastructure.model.entity.SecurityLog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SecurityLogsRepositoryInterface {
    SecurityLog save(SecurityLog securityLog);
    Optional<SecurityLog> findByUserId(UUID userId);
    List<SecurityLog> findByGate(String gate);
    long countCurrentCheckInsWithoutCheckOut();
    Optional<SecurityLog> isUserLastActionCheckIn(UUID userId);
}
