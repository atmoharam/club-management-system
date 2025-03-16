package dev.payment.infrastructure.model.mapper;

import dev.common.domain.cons.PaymentStatus;
import dev.payment.domain.model.entites.PaymentDomainEntity;
import dev.payment.infrastructure.model.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment paymentDomainToPayment(PaymentDomainEntity paymentDomainEntity) {
        return Payment.builder()
                .amount(paymentDomainEntity.getAmount())
                .status(paymentDomainEntity.getStatus().toString())
                .userId(paymentDomainEntity.getUserId())
                .timestamp(paymentDomainEntity.getTimestamp())
                .build();
    }

    public PaymentDomainEntity paymentToPaymentDomain(Payment payment) {
        return
                PaymentDomainEntity.builder()
                        .id(payment.getId())
                        .amount(payment.getAmount())
                        .status(PaymentStatus.valueOf(payment.getStatus()))
                        .userId(payment.getUserId())
                        .timestamp(payment.getTimestamp())
                        .build();

    }
}
