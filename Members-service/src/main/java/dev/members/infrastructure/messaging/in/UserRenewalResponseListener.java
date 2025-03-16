package dev.members.infrastructure.messaging.in;

import dev.kafka.service.configuration.Topics;
import dev.members.application.service.RenewMembershipUseCase;
import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserRenewalResponseListener {

    @Autowired
    private RenewMembershipUseCase renewMembershipUseCase;

    @KafkaListener(topics = Topics.USER_RENEW_MEMBERSHIP_RES, groupId = "club-group")
    public void consume(UserRenewMembershipResponse userRenewMembershipResponse){
        renewMembershipUseCase.execute(userRenewMembershipResponse);
        log.info("Received userRenewMembershipResponse {}", userRenewMembershipResponse);
    }
}
