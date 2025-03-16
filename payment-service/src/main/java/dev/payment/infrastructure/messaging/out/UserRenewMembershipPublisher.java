package dev.payment.infrastructure.messaging.out;

import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserRenewMembershipPublisher {

    private final KafkaTemplate<String,
            UserRenewMembershipResponse> kafkaTemplate;

    public void publish(UserRenewMembershipResponse userRenewMembershipResponse) {
        log.info("Publishing user renew membership request: {}", userRenewMembershipResponse);
        kafkaTemplate.send("user-renew-membership-request", userRenewMembershipResponse).whenComplete(
                (res ,ex) ->{
                    if (ex == null) {
                        log.info("Sent message=[{}] with offset=[{}]", userRenewMembershipResponse, res.getRecordMetadata().offset());
                    } else {
                        log.error("Unable to send message=[{}] due to : {}", userRenewMembershipResponse, ex.getMessage());
                    }
                }
        );

    }
}
