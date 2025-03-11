package dev.members.application.service;

import dev.kafka.avro.UserSubscribeSportResponse;

import java.util.UUID;

public class SubscribeSportUseCase {

    public void execute(UUID userId, UUID sportId) {
        // 1 - get user data
        // 2 - sending data to payment service
    }
    // 3 - receiving data from payment service
    public void execute(UserSubscribeSportResponse userSubscribeSportResponse) {
        // 4 - if success call service to create the subscription
        // 5 - save this in DB
    }
}
