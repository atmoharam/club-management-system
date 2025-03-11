package dev.members.infrastructure.messaging.in;

import dev.kafka.avro.UserRenewMembershipResponse;
import dev.kafka.service.configuration.Topics;
import dev.members.application.service.RenewMembershipUseCase;
import dev.members.infrastructure.messaging.out.UserRenewalRequestPublisher;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserRenewalResponseListener {
    private static final Logger log = LoggerFactory.getLogger(UserRenewalRequestPublisher.class);

    @KafkaListener(topics = Topics.USER_RENEW_MEMBERSHIP_RES, groupId = "club-group")
    public void consume(UserRenewMembershipResponse userRenewMembershipResponse){
        RenewMembershipUseCase renewMembershipUseCase = new RenewMembershipUseCase();
        renewMembershipUseCase.execute(userRenewMembershipResponse);
        log.info("Received userRenewMembershipResponse {}", userRenewMembershipResponse);
    }
}
