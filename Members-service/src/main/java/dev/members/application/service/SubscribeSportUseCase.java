package dev.members.application.service;

import dev.kafka.avro.UserSubscribeSportRequest;
import dev.kafka.avro.UserSubscribeSportResponse;
import dev.members.infrastructure.adapter.UserDB;
import dev.members.infrastructure.adapter.UserSportDB;
import dev.members.infrastructure.messaging.out.UserSubscribeSportRequestPublisher;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.entites.UserSport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class SubscribeSportUseCase {

    @Autowired
    private UserSubscribeSportRequestPublisher publisher;
    @Autowired
    private UserSportDB userSportDB;
    @Autowired
    private UserDB userDB;

    public void execute(UUID userId, UUID sportId) {
        UserSubscribeSportRequest userAvro = UserSubscribeSportRequest.newBuilder().
                setUserId(userId.toString()).
                setSportId(sportId.toString())
                .setSubscriptionDate(System.currentTimeMillis()).
                build();
        publisher.publish(userAvro);

    }
    // 3 - receiving data from payment service
    public void execute(UserSubscribeSportResponse userSubscribeSportResponse) {
        // 4 - if success call service to create subscription
        User user = userDB.getUserByID(UUID.fromString(userSubscribeSportResponse.
                        getUserId().toString())).orElse(null);

        UserSport userSport = UserSport.builder()
                .sportId(UUID.fromString(userSubscribeSportResponse.
                        getSportId().toString()))
                .user(user)
                .subscribedAt(Instant.now())
                .build();
        // 5 - save this in DB
        userSportDB.save(userSport);
    }
}
