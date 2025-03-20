package dev.payment.infrastructure.messaging.out;

import dev.kafka.service.configuration.Topics;
import dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserSubscribeSportPublisher {

    private final KafkaTemplate<String, UserSubscribeSportResponse> kafkaTemplate;
    public void publish(UserSubscribeSportResponse userSubscribeSportResponse){
        log.info("Publishing user renew membership response: {}", userSubscribeSportResponse);
        kafkaTemplate.send(Topics.USER_SUBSCRIBE_SPORT_RES, userSubscribeSportResponse).whenComplete(
                (res ,ex) ->{
                    if (ex == null) {
                        log.info("Sent message=[{}] with offset=[{}]", userSubscribeSportResponse, res.getRecordMetadata().offset());
                    } else {
                        log.error("Unable to send message=[{}] due to : {}", userSubscribeSportResponse, ex.getMessage());
                    }
                }
        );
    }

}
