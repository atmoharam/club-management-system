package dev.payment.infrastructure.model.repository;

import dev.payment.infrastructure.model.entity.SportSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SportSubscriptionRepository extends JpaRepository<SportSubscription, UUID> {
    Optional<SportSubscription> findByUserId(UUID sportId);
    Optional<SportSubscription> findByUserIdAndSportId(UUID id, UUID sportId);
    Optional<SportSubscription> findBySportId(UUID sportId);
}
