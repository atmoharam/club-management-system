package dev.payment.infrastructure.adapter;

import dev.payment.domain.repository.PaymentRepositoryInterface;
import dev.payment.infrastructure.model.entity.Payment;
import dev.payment.infrastructure.model.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Builder
public class PaymentDB implements PaymentRepositoryInterface {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
