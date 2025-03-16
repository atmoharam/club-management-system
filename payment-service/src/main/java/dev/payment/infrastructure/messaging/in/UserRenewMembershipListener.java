package dev.payment.infrastructure.messaging.in;

import dev.kafka.avro.SecurityAction;
import dev.kafka.avro.UserRenewMembershipRequest;
import dev.kafka.service.configuration.Topics;
import dev.payment.application.service.ConfirmPayment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class UserRenewMembershipListener {

    @Autowired
    ConfirmPayment confirmPayment;

    @KafkaListener(topics = Topics.USER_RENEW_MEMBERSHIP_REQ, groupId = "club-group")
    public void consume(UserRenewMembershipRequest request){
        log.info("Received userRenewMembershipRequest {}", request);
        confirmPayment.process(request);
    }
}
