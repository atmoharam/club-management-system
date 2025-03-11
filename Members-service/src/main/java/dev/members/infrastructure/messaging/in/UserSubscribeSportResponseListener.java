package dev.members.infrastructure.messaging.in;

import dev.kafka.avro.UserSubscribeSportResponse;
import dev.kafka.service.configuration.Topics;
import dev.members.application.service.SubscribeSportUseCase;
import dev.members.infrastructure.messaging.out.UserRenewalRequestPublisher;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
