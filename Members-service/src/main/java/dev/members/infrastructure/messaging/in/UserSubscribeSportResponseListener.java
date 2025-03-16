package dev.members.infrastructure.messaging.in;

import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportResponse;
import dev.members.application.service.SubscribeSportUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserSubscribeSportResponseListener {
    @Autowired
    SubscribeSportUseCase subscribeSportUseCase;

    @KafkaListener(topics = Topics.USER_SUBSCRIBE_SPORT_RES , groupId = "club-group")
    public void consume(UserSubscribeSportResponse userSubscribeSportResponse){
        log.info("Received userRenewMembershipResponse {}", userSubscribeSportResponse);
        subscribeSportUseCase.execute(userSubscribeSportResponse);


    }
}
