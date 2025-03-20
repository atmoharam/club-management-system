package dev.payment.domain.model.entites;

import dev.payment.infrastructure.model.entity.Payment;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SportSubscriptionDomainEntity {
    private UUID id;
    private UUID userId;
    private UUID sportId;
    private PaymentDomainEntity payment;
    private LocalDate subscriptionStartDate;
    private LocalDate subscriptionEndDate;
}
