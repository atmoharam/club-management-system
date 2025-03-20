package dev.security.gate.service.infrastructure.messaging.in;

import dev.common.domain.cons.MembershipStatus;
import dev.common.domain.cons.PaymentStatus;
import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipResponse;
import dev.security.gate.service.application.UserRenewalMembership;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Slf4j
public class UserRenewalMembershipListener {

    @Autowired
    UserRenewalMembership userRenewalMembership;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnn");


    @KafkaListener(topics = Topics.USER_RENEW_MEMBERSHIP_RES, groupId = "club-group-second")
    public void consume(ConsumerRecord<String, UserRenewMembershipResponse> res){
        log.info("consumed {}", res.value());
        if(res.value().getStatus().toString().equals("Completed"))
        {
            userRenewalMembership.
                    renewalMembership(UUID.fromString(res.value().getUserId().toString())
                            , MembershipStatus.valueOf((MembershipStatus.Active).toString())
                            , LocalDate.parse(res.value().getExpirationDate().toString().substring(0,10))
                    );
        }

    }
}
