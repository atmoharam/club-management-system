package dev.payment.infrastructure.adapter;

import dev.payment.domain.repository.SportSubscriptionRepositoryInterface;
import dev.payment.infrastructure.model.entity.SportSubscription;
import dev.payment.infrastructure.model.repository.SportSubscriptionRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
@Builder
public class SportSubscriptionDB implements SportSubscriptionRepositoryInterface {
    @Autowired
    private SportSubscriptionRepository sportSubscriptionRepository;

    @Override
    public SportSubscription save(SportSubscription sportSubscription) {
        return sportSubscriptionRepository.save(sportSubscription);
    }

    @Override
    public Optional<SportSubscription> findByUserId(UUID userId) {
        return sportSubscriptionRepository.findByUserId(userId);
    }

    @Override
    public Optional<SportSubscription> findByUserIdAndSportId(UUID id, UUID sportId) {
        return sportSubscriptionRepository.findByUserIdAndSportId(id, sportId);
    }

    @Override
    public Optional<SportSubscription> findBySportId(UUID sportId) {
        return sportSubscriptionRepository.findBySportId(sportId);
    }

}
