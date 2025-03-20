package dev.payment.infrastructure.messaging.out;

import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRenewMembershipPublisher {

    private final KafkaTemplate<String, UserRenewMembershipResponse> kafkaTemplate;

    public void publish(UserRenewMembershipResponse userRenewMembershipResponse) {
        log.info("Publishing user renew membership response: {}", userRenewMembershipResponse);
        kafkaTemplate.send(Topics.USER_RENEW_MEMBERSHIP_RES, userRenewMembershipResponse).whenComplete(
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
