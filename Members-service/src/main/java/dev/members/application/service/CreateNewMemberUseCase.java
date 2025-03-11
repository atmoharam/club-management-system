package dev.members.application.service;

import dev.members.domain.model.entities.UserDomainEntity;
import dev.members.domain.service.MebershipRenewalService;
import dev.members.infrastructure.adapter.UserDB;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateNewMemberUseCase {
    @Autowired
    UserDB userDB;
    @Autowired
    MebershipRenewalService mebershipRenewalService;
    @Autowired
    private final UserMapper userMapper;

    public void createNewUser(UserDomainEntity userDomainEntity){
        // 1 - check if already in DB
        User user = userDB.getUserByEmail(userDomainEntity.getEmail()).orElse(null);
        if(user == null){
            // 2 - renew membership
            userDomainEntity.setCreatedAt(Instant.now());
            userDomainEntity.setUpdatedAt(Instant.now());
            mebershipRenewalService.renewMembership(userDomainEntity);
            // 3 - save in DB
            userDB.saveUser(userMapper.userDomainToUser(userDomainEntity));
        }

    }
}
