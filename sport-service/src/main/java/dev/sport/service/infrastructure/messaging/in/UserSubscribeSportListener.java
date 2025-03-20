package dev.sport.service.infrastructure.messaging.in;

import dev.kafka.service.configuration.Topics;
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

    private final UserFollowSportUseCase userFollowSportUseCase;

    @Autowired
    public UserSubscribeSportListener(UserFollowSportUseCase userFollowSportUseCase) {
        this.userFollowSportUseCase = userFollowSportUseCase;
    }

    @KafkaListener(topics = Topics.USER_SUBSCRIBE_SPORT_RES , groupId = "club-group-second")
    public void consume(ConsumerRecord<String, UserSubscribeSportResponse> response){
        log.info("Received User Subscribe Sport Response {}", response.value());
        userFollowSportUseCase.process(
                UUID.fromString(response.value().getUserId().toString()) ,
                UUID.fromString(response.value().getSportId().toString()));
    }
}
