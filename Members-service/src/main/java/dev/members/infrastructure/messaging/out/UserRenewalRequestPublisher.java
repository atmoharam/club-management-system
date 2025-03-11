package dev.members.infrastructure.messaging.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import dev.kafka.avro.UserRenewMembershipRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRenewalRequestPublisher {
    private final KafkaTemplate<String, UserRenewMembershipRequest> kafkaTemplate;

    public void publish(UserRenewMembershipRequest userRenewMembershipRequest) {
        log.info("Publishing user renew membership request: {}", userRenewMembershipRequest);
        kafkaTemplate.send("user-renew-membership-request", userRenewMembershipRequest).whenComplete(
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
