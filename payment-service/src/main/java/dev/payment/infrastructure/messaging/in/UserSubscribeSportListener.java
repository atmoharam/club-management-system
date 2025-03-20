package dev.payment.infrastructure.messaging.in;

import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest;
import dev.payment.application.service.ConfirmSubscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class UserSubscribeSportListener {

    @Autowired
    ConfirmSubscription confirmSubscription;

    @KafkaListener(topics = Topics.USER_SUBSCRIBE_SPORT_REQ, groupId = "club-group")
    public void consume(ConsumerRecord<String , UserSubscribeSportRequest> request){
        log.info("Received UserSubscribeSportRequest {}", request.value());

        confirmSubscription.process
                (UUID.fromString(request.value().getUserId().toString())
                        ,UUID.fromString( request.value().getSportId().toString()));
    }


}
