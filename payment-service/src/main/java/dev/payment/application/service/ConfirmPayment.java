package dev.payment.application.service;

import dev.common.domain.cons.PaymentStatus;
import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipRequest;
import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipResponse;
import dev.payment.domain.model.entites.MembershipRenewalDomainEntity;
import dev.payment.domain.model.entites.PaymentDomainEntity;
import dev.payment.domain.service.MembershipRenewalService;
import dev.payment.domain.service.PaymentService;
import dev.payment.infrastructure.adapter.MembershipRenewalDB;
import dev.payment.infrastructure.adapter.PaymentDB;
import dev.payment.infrastructure.messaging.out.UserRenewMembershipPublisher;
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
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private MembershipRenewalService membershipRenewalService;
    @Autowired
    private PaymentDB paymentDB;
    @Autowired
    private MembershipRenewalDB membershipRenewalDB;
    @Autowired
    private UserRenewMembershipPublisher userRenewMembershipPublisher;
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private MembershipRenewalMapper membershipRenewalMapper;
    public void process(UserRenewMembershipRequest request){
        Random rand = new Random();
        //get data from service
        //check the amount
        // call approve to push acceptance.

        MembershipRenewalDomainEntity membershipRenewalDomain =
                MembershipRenewalDomainEntity.builder()
                .amount(BigDecimal.valueOf(rand.nextInt(1000)))
                        .timestamp(Instant.now())
                        .userId(UUID.fromString(request.getUserId().toString()))
                .build();
        if((membershipRenewalDomain.getAmount()).intValue() >= 500){
            approvePayment(membershipRenewalDomain);
        }
        else{
            faildPayment(membershipRenewalDomain);
        }
    }
    public void approvePayment(MembershipRenewalDomainEntity membershipRenewalDomain){
        // push to kafka
        UserRenewMembershipResponse userRenewMembershipResponse =
                UserRenewMembershipResponse.
                        newBuilder().setUserId(membershipRenewalDomain.getUserId().toString()).
                        setExpirationDate(
                                membershipRenewalDomain.getTimestamp()
                                        .plus(30 , ChronoUnit.DAYS).toString()).
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

        paymentDB.save(paymentMapper.
                paymentDomainToPayment(paymentDomainEntity));
        membershipRenewalDB.
                save(membershipRenewalMapper.
                        membershipRenewalDomainToEntity(membershipRenewalDomain));
    }

    public void faildPayment(MembershipRenewalDomainEntity membershipRenewalDomain){
        UserRenewMembershipResponse userRenewMembershipResponse =
                UserRenewMembershipResponse.
                        newBuilder().setUserId(membershipRenewalDomain.getUserId().toString()).
                        setExpirationDate(
                                membershipRenewalDomain.getTimestamp().toString()).
                        setStatus(PaymentStatus.Failed.toString()).
                        build();

        userRenewMembershipPublisher.publish(userRenewMembershipResponse);
        // save to DB
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
