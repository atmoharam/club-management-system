package dev.members.application.service;

import dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest;
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

    public void sending(UUID userId, UUID sportId) {
        UserSubscribeSportRequest userAvro = UserSubscribeSportRequest.newBuilder().
                setUserId(userId.toString()).
                setSportId(sportId.toString()).
                build();
        publisher.publish(userAvro);

    }
    // 3 - receiving data from payment service
    public void execute(UUID userId , UUID sportId) {
        User user = userDB.getUserByID(userId).orElse(null);

        UserSport userSport = UserSport.builder()
                .sportId(sportId)
                .user(user)
                .subscribedAt(Instant.now())
                .build();
        // 5 - save this in DB
        userSportDB.save(userSport);
    }
}
