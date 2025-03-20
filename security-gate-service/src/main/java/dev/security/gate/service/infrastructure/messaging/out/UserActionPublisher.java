package dev.security.gate.service.infrastructure.messaging.out;

import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.SecurityAction;
import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserActionPublisher {

    private final KafkaTemplate<String, SecurityAction> kafkaTemplate;

    public void publish(SecurityAction securityAction) {
        log.info("Publishing user renew membership request: {}", securityAction);
        kafkaTemplate.send(Topics.SECURITY_ACTION, securityAction).whenComplete(
                (res ,ex) ->{
                    if (ex == null) {
                        log.info("Sent message=[{}] with offset=[{}]", securityAction, res.getRecordMetadata().offset());
                    } else {
                        log.error("Unable to send message=[{}] due to : {}", securityAction, ex.getMessage());
                    }
                }
        );

    }

}
