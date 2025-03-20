package dev.payment.application.service;

import dev.common.domain.cons.PaymentStatus;
import dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportResponse;
import dev.payment.domain.model.entites.PaymentDomainEntity;
import dev.payment.domain.model.entites.SportSubscriptionDomainEntity;
import dev.payment.infrastructure.adapter.PaymentDB;
import dev.payment.infrastructure.adapter.SportSubscriptionDB;
import dev.payment.infrastructure.messaging.out.UserSubscribeSportPublisher;
import dev.payment.infrastructure.model.entity.Payment;
import dev.payment.infrastructure.model.mapper.PaymentMapper;
import dev.payment.infrastructure.model.mapper.SportSubscriptionMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ConfirmSubscription {

    private PaymentDB paymentDB;
    private SportSubscriptionDB sportSubscriptionDB;
    private PaymentMapper paymentMapper;
    private SportSubscriptionMapper sportSubscriptionMapper;
    private UserSubscribeSportPublisher userSubscribeSportPublisher;
    
    Random rand;

    @Autowired
    public ConfirmSubscription(PaymentDB paymentDB, PaymentMapper paymentMapper, SportSubscriptionDB sportSubscriptionDB, SportSubscriptionMapper sportSubscriptionMapper, UserSubscribeSportPublisher userSubscribeSportPublisher) {
        this.paymentDB = paymentDB;
        this.paymentMapper = paymentMapper;
        this.sportSubscriptionDB = sportSubscriptionDB;
        this.sportSubscriptionMapper = sportSubscriptionMapper;
        this.userSubscribeSportPublisher = userSubscribeSportPublisher;
        rand = new Random();
    }

    public void process(UUID userId,UUID sportId) {
        int amountRand = rand.nextInt(1000);
        PaymentDomainEntity paymentDomainEntity =
                PaymentDomainEntity.builder()
                        .amount(BigDecimal.valueOf(amountRand))
                        .timestamp(Instant.now())
                        .userId(userId)
                        .status(amountRand >= 500 ? PaymentStatus.Failed : PaymentStatus.Completed)
                        .build();
        log.info("payment created {}" , paymentDomainEntity);
        Payment payment = paymentDB.save(paymentMapper.paymentDomainToPayment(paymentDomainEntity));

        SportSubscriptionDomainEntity sportSubscriptionDomainEntity =
                SportSubscriptionDomainEntity.builder()
                        .payment(paymentDomainEntity)
                        .subscriptionStartDate(LocalDate.now())
                        .subscriptionEndDate(LocalDate.now().minusDays(30))
                        .sportId(sportId)
                        .userId(userId)
                        .build();

        UserSubscribeSportResponse response =
                UserSubscribeSportResponse.newBuilder()
                        .setUserId(sportSubscriptionDomainEntity.getUserId().toString())
                        .setSportId(sportSubscriptionDomainEntity.getSportId().toString())
                        .setStatus(sportSubscriptionDomainEntity.getPayment().getStatus().toString())
                        .build();
        log.info("Response {}", response);
        userSubscribeSportPublisher.publish(response);
        log.info("SportSubscription published");
        sportSubscriptionDB.save(
                sportSubscriptionMapper.
                        SportDomianToModel(sportSubscriptionDomainEntity
                        , payment));

    }

}
