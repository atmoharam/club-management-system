package dev.payment.domain.model.entites;

import dev.common.domain.cons.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDomainEntity {
    private UUID id;
    private UUID userId;
    private BigDecimal amount;
    private PaymentStatus status;
    private Instant timestamp;

}
