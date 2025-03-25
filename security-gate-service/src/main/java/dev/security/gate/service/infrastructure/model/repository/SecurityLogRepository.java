package dev.security.gate.service.infrastructure.model.repository;

import dev.security.gate.service.infrastructure.model.entity.SecurityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SecurityLogRepository extends JpaRepository<SecurityLog, UUID> {
    public Optional<SecurityLog> findByUserId(UUID id);
    public List<SecurityLog> findAllByGate(String gate);
    public Long countByAction(String action);
    public Optional<SecurityLog> findTopByUserIdOrderByTimestampDesc(UUID id);
}
