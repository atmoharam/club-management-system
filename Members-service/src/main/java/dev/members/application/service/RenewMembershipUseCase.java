package dev.members.application.service;

import dev.kafka.avro.UserRenewMembershipRequest;
import dev.kafka.avro.UserRenewMembershipResponse;
import dev.members.infrastructure.adapter.UserDB;
import dev.members.infrastructure.messaging.out.UserRenewalRequestPublisher;
import dev.members.infrastructure.model.entites.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;


public class RenewMembershipUseCase {
    UserDB userDB = new UserDB();
    private UserRenewalRequestPublisher userRenewalRequestPublisher;
    long timestamp = System.currentTimeMillis();


    public void execute(UUID memberId) {
        // 1 - get user from DB
//        User user = userDB.getUserByID(memberId).orElse(null);
        // 2 - send data to payment service


        UserRenewMembershipRequest userRenewMembershipRequest =
                UserRenewMembershipRequest.newBuilder().
                setUserId(UUID.randomUUID().toString()).
                setRequestTimestamp(System.currentTimeMillis())
                        .build();


        userRenewalRequestPublisher.publish(userRenewMembershipRequest);
        // 3 - make the status pending
    }

    // 3 - get response from payment service
    public void execute(UserRenewMembershipResponse userRenewMembershipResponse) {
        // 4 - if success call service to renew membership
        // 5 - save in DB
    }
}
