package dev.payment.domain.repository;

import dev.payment.infrastructure.model.entity.Payment;

public interface PaymentRepositoryInterface {
    Payment save(Payment payment);
}
