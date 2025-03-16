package dev.payment.infrastructure.adapter;

import dev.payment.domain.repository.SportSubscriptionRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Builder
public class SportSubscriptionDB implements SportSubscriptionRepositoryInterface {

}
