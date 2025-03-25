package dev.members.infrastructure.messaging.in;

import dev.common.domain.cons.PaymentStatus;
import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportResponse;
import dev.members.application.service.SubscribeSportUseCase;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserSubscribeSportResponseListener {
    @Autowired
    SubscribeSportUseCase subscribeSportUseCase;

    @KafkaListener(topics = Topics.USER_SUBSCRIBE_SPORT_RES , groupId = "club-group")
    public void consume(ConsumerRecord< String , UserSubscribeSportResponse> userSubscribeSportResponse){
        log.info("Received userRenewMembershipResponse {}", userSubscribeSportResponse);
        log.info("here the result {}" , PaymentStatus.valueOf(userSubscribeSportResponse.value().getStatus().toString()));
        if(!userSubscribeSportResponse.value().getStatus().toString().equals("Failed"))
        {
            subscribeSportUseCase.receiving(
                    UUID.fromString(userSubscribeSportResponse.value().getUserId().toString()) ,
                    UUID.fromString(userSubscribeSportResponse.value().getSportId().toString())
            );
        }


    }
}
