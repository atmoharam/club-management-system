package dev.payment.infrastructure.model.mapper;

import dev.payment.domain.model.entites.SportSubscriptionDomainEntity;
import dev.payment.infrastructure.model.entity.Payment;
import dev.payment.infrastructure.model.entity.SportSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportSubscriptionMapper {
    @Autowired
    PaymentMapper paymentMapper;

    public SportSubscription SportDomianToModel
            (SportSubscriptionDomainEntity sportSubscriptionDomainEntity
            , Payment payment) {
        return SportSubscription.builder()
                .sportId(sportSubscriptionDomainEntity.getSportId())
                .subscriptionEndDate(sportSubscriptionDomainEntity.getSubscriptionEndDate())
                .subscriptionStartDate(sportSubscriptionDomainEntity.getSubscriptionStartDate())
                .userId(sportSubscriptionDomainEntity.getUserId())
                .payment(payment)
                .build();
    }

    public SportSubscriptionDomainEntity  SportModelToDomain(SportSubscription sportSubscription) {
        return SportSubscriptionDomainEntity.builder()
                .sportId(sportSubscription.getSportId())
                .userId(sportSubscription.getUserId())
                .subscriptionStartDate(sportSubscription.getSubscriptionStartDate())
                .subscriptionEndDate(sportSubscription.getSubscriptionEndDate())
                .payment(paymentMapper.paymentToPaymentDomain(sportSubscription.getPayment()))
                .build();
    }

}
