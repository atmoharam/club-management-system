package dev.payment.domain.repository;

import dev.payment.infrastructure.model.entity.SportSubscription;

import java.util.Optional;
import java.util.UUID;

public interface SportSubscriptionRepositoryInterface {
    SportSubscription save(SportSubscription sportSubscription);
    Optional<SportSubscription> findByUserId(UUID userId);
    Optional<SportSubscription> findByUserIdAndSportId(UUID id, UUID sportId);
    Optional<SportSubscription> findBySportId(UUID sportId);}
