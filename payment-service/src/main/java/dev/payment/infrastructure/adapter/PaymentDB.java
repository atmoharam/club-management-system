package dev.payment.infrastructure.adapter;

import dev.payment.domain.repository.PaymentRepositoryInterface;
import dev.payment.infrastructure.model.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Builder
public class PaymentDB implements PaymentRepositoryInterface {

    @Override
    public Payment save(Payment payment) {
        return null;
    }
}
