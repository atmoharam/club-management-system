package dev.members.application.service;

import dev.members.domain.model.entities.UserDomainEntity;
import dev.members.domain.service.MebershipRenewalService;
import dev.members.infrastructure.adapter.UserDB;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class CreateNewMemberUseCase {
    private final UserDB userDB;
    private final MebershipRenewalService mebershipRenewalService;
    private final UserMapper userMapper;

    public void createNewUser(UserDomainEntity userDomainEntity){
        User user = userDB.getUserByEmail(userDomainEntity.getEmail()).orElse(null);
        if(user == null){
            userDomainEntity.setCreatedAt(Instant.now());
            userDomainEntity.setUpdatedAt(Instant.now());
            mebershipRenewalService.renewMembership(userDomainEntity);
            userDB.saveUser(userMapper.userDomainToUser(userDomainEntity));
        }

    }
}
