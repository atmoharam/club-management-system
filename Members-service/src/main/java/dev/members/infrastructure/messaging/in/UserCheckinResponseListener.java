package dev.members.infrastructure.messaging.in;


import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.SecurityAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserCheckinResponseListener {

    @KafkaListener(topics = Topics.SECURITY_ACTION, groupId = "club-group")
    public void consume(SecurityAction securityAction){
        log.info("Received userRenewMembershipResponse {}", securityAction);
    }
}
