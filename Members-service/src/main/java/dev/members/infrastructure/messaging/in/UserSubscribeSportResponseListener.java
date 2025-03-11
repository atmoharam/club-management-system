package dev.members.infrastructure.messaging.in;

import dev.kafka.avro.UserSubscribeSportResponse;
import dev.kafka.service.configuration.Topics;
import dev.members.infrastructure.messaging.out.UserRenewalRequestPublisher;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserSubscribeSportResponseListener {
    private static final Logger log = LoggerFactory.getLogger(UserRenewalRequestPublisher.class);

    @KafkaListener(topics = Topics.USER_SUBSCRIBE_SPORT_RES , groupId = "club-group")
    public void consume(UserSubscribeSportResponse userSubscribeSportResponse){
        log.info("Received userRenewMembershipResponse {}", userSubscribeSportResponse);


    }
}
