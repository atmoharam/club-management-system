package dev.members.application.service;

import dev.members.infrastructure.adapter.UserCheckinDB;
import dev.members.infrastructure.adapter.UserDB;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.entites.UserCheckIn;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ActionsUseCase {
    UserCheckinDB userCheckinDB;
    UserDB userDB;

    public void execute(UUID actionId,UUID userId, String actionType){

        User user = userDB.getUserByID(userId).orElse(null);
        if(user != null){
            UserCheckIn userCheckIn = UserCheckIn.builder()
                    .id(actionId)
                    .timestamp(Instant.now())
                    .action(actionType)
                    .user(user)
                    .build();
            userCheckinDB.save(userCheckIn);
        }
    }
}
