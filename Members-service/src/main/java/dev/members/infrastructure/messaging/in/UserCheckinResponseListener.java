package dev.members.infrastructure.messaging.in;


import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.SecurityAction;
import dev.members.application.service.ActionsUseCase;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserCheckinResponseListener {

    @Autowired
    ActionsUseCase actionsUseCase;
    @KafkaListener(topics = Topics.SECURITY_ACTION, groupId = "club-group")
    public void consume(ConsumerRecord<String,SecurityAction> securityAction){
        log.info("Received userRenewMembershipResponse {}", securityAction.value());
        actionsUseCase.execute(
                UUID.fromString(securityAction.value().getActionId().toString())
        ,UUID.fromString(securityAction.value().getUserId().toString())
                ,securityAction.value().getActionType().toString()
        );
    }
}
