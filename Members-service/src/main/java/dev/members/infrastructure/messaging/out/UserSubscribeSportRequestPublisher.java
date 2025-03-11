package dev.members.infrastructure.messaging.out;

import dev.kafka.avro.UserRenewMembershipRequest;
import dev.kafka.avro.UserSubscribeSportRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSubscribeSportRequestPublisher {
    private final KafkaTemplate<String, UserSubscribeSportRequest> kafkaTemplate;
    private static final Logger log = LoggerFactory.getLogger(UserRenewalRequestPublisher.class);

    public void publish(UserSubscribeSportRequest userSubscribeSportRequest) {
        log.info("Publishing userSubscribeSportRequest: {}", userSubscribeSportRequest);
        kafkaTemplate.send("out", userSubscribeSportRequest).whenComplete(
                (res , ex) ->{
                    if (ex == null) {
                        log.info("Sent message=[{}] with offset=[{}]", userSubscribeSportRequest, res.getRecordMetadata().offset());
                    } else {
                        log.error("Unable to send message=[{}] due to : {}", userSubscribeSportRequest, ex.getMessage());
                    }
                }
        );

    }
}
