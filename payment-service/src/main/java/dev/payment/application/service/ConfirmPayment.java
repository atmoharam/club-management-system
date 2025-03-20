package dev.payment.application.service;

import dev.common.domain.cons.PaymentStatus;
import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipResponse;
import dev.payment.domain.model.entites.MembershipRenewalDomainEntity;
import dev.payment.domain.model.entites.PaymentDomainEntity;
import dev.payment.infrastructure.adapter.MembershipRenewalDB;
import dev.payment.infrastructure.adapter.PaymentDB;
import dev.payment.infrastructure.messaging.out.UserRenewMembershipPublisher;
import dev.payment.infrastructure.model.entity.Payment;
import dev.payment.infrastructure.model.mapper.MembershipRenewalMapper;
import dev.payment.infrastructure.model.mapper.PaymentMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmPayment {
    private PaymentDB paymentDB;
    private MembershipRenewalDB membershipRenewalDB;
    private UserRenewMembershipPublisher userRenewMembershipPublisher;
    private PaymentMapper paymentMapper;
    private MembershipRenewalMapper membershipRenewalMapper;
    Random rand = new Random();

    @Autowired
    public ConfirmPayment(PaymentMapper paymentMapper, MembershipRenewalMapper membershipRenewalMapper, PaymentDB paymentDB, MembershipRenewalDB membershipRenewalDB, UserRenewMembershipPublisher userRenewMembershipPublisher) {
        this.paymentMapper = paymentMapper;
        this.membershipRenewalMapper = membershipRenewalMapper;
        this.paymentDB = paymentDB;
        this.membershipRenewalDB = membershipRenewalDB;
        this.userRenewMembershipPublisher = userRenewMembershipPublisher;
    }

    public void process(String userId){
        MembershipRenewalDomainEntity membershipRenewalDomain =
                MembershipRenewalDomainEntity.builder()
                .amount(BigDecimal.valueOf(rand.nextInt(1000)))
                        .timestamp(Instant.now())
                        .userId(UUID.fromString(userId))
                .build();
        if((membershipRenewalDomain.getAmount()).intValue() >= 500){
            approvePayment(membershipRenewalDomain);
        }
        else{
            failedPayment(membershipRenewalDomain);
        }
    }
    public void approvePayment(MembershipRenewalDomainEntity membershipRenewalDomain){
        UserRenewMembershipResponse userRenewMembershipResponse =
                UserRenewMembershipResponse.
                        newBuilder().setUserId(membershipRenewalDomain.getUserId().toString()).
                        setExpirationDate(
                                membershipRenewalDomain.getTimestamp()
                                        .plus(365, ChronoUnit.DAYS).toString()).
                        setStatus(PaymentStatus.Completed.toString()).
                        build();

        userRenewMembershipPublisher.publish(userRenewMembershipResponse);
        // save to DB
        PaymentDomainEntity paymentDomainEntity = PaymentDomainEntity
                .builder()
                .amount(membershipRenewalDomain.getAmount())
                .userId(membershipRenewalDomain.getUserId())
                .timestamp(membershipRenewalDomain.getTimestamp())
                .status(PaymentStatus.Completed).
                build();

        Payment payment = paymentMapper.
                paymentDomainToPayment(paymentDomainEntity);
        paymentDB.save(payment);
        membershipRenewalDB.
                save(membershipRenewalMapper.
                        membershipRenewalDomainToEntity(membershipRenewalDomain));
    }

    public void failedPayment(MembershipRenewalDomainEntity membershipRenewalDomain){
        UserRenewMembershipResponse userRenewMembershipResponse =
                UserRenewMembershipResponse.
                        newBuilder().setUserId(membershipRenewalDomain.getUserId().toString()).
                        setExpirationDate(
                                membershipRenewalDomain.getTimestamp().toString()).
                        setStatus(PaymentStatus.Failed.toString()).
                        build();

        userRenewMembershipPublisher.publish(userRenewMembershipResponse);
        PaymentDomainEntity paymentDomainEntity = PaymentDomainEntity
                .builder()
                .amount(membershipRenewalDomain.getAmount())
                .userId(membershipRenewalDomain.getUserId())
                .timestamp(membershipRenewalDomain.getTimestamp())
                .status(PaymentStatus.Failed).
                build();

        paymentDB.save(paymentMapper.
                paymentDomainToPayment(paymentDomainEntity));
        membershipRenewalDB.
                save(membershipRenewalMapper.
                        membershipRenewalDomainToEntity(membershipRenewalDomain));
    }



}
