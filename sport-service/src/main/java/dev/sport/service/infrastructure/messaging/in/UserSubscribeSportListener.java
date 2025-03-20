package dev.sport.service.infrastructure.messaging.in;

import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipRequest;
import dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportResponse;
import dev.sport.service.application.UserFollowSportUseCase;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserSubscribeSportListener {

    @Autowired
    UserFollowSportUseCase userFollowSportUseCase;
    @KafkaListener(topics = Topics.USER_SUBSCRIBE_SPORT_RES, groupId = "club-group")
    public void consume(ConsumerRecord<String , UserSubscribeSportResponse> response){
        log.info("Received UserSubscribeSportResponse {}", response.value());
        userFollowSportUseCase.process(UUID.fromString(response.value().getUserId().toString()) , UUID.fromString(response.value().getSportId().toString()));
    }
}
