package dev.members.application.service;

import dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest;
import dev.members.infrastructure.adapter.UserDB;
import dev.members.infrastructure.adapter.UserSportDB;
import dev.members.infrastructure.messaging.out.UserSubscribeSportRequestPublisher;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.entites.UserSport;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class SubscribeSportUseCase {

    private UserSubscribeSportRequestPublisher publisher;
    private UserSportDB userSportDB;
    private UserDB userDB;

    public void sending(UUID userId, UUID sportId) {
        UserSubscribeSportRequest userAvro = UserSubscribeSportRequest.newBuilder().
                setUserId(userId.toString()).
                setSportId(sportId.toString()).
                build();
        publisher.publish(userAvro);
    }

    public void receiving(UUID userId , UUID sportId) {
        User user = userDB.getUserByID(userId).orElse(null);

        UserSport userSport = UserSport.builder()
                .sportId(sportId)
                .user(user)
                .subscribedAt(Instant.now())
                .build();
        userSportDB.save(userSport);
    }

    public boolean isSuccess(UUID userId) {
        return userSportDB.findByUserId(userId).isPresent();
    }
}
