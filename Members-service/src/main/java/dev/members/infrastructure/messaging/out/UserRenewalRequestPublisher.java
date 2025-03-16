package dev.members.infrastructure.messaging.out;

import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRenewalRequestPublisher {
    private final KafkaTemplate<String, UserRenewMembershipRequest> kafkaTemplate;

    public void publish(UserRenewMembershipRequest userRenewMembershipRequest) {
        log.info("Publishing user renew membership request: {}", userRenewMembershipRequest);
        kafkaTemplate.send(Topics.USER_RENEW_MEMBERSHIP_REQ, userRenewMembershipRequest).whenComplete(
                (res ,ex) ->{
                    if (ex == null) {
                        log.info("Sent message=[{}] with offset=[{}]", userRenewMembershipRequest, res.getRecordMetadata().offset());
                    } else {
                        log.error("Unable to send message=[{}] due to : {}", userRenewMembershipRequest, ex.getMessage());
                    }
                }
        );

    }



}
