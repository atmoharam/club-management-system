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
import java.time.LocalDate;

@Service
@Slf4j
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class MemberManagementUseCase {
    private final UserDB userDB;
    private final MebershipRenewalService mebershipRenewalService;
    private final RenewMembershipUseCase renewMembershipUseCase;
    private final UserMapper userMapper;

    public void createNewUser(UserDomainEntity userDomainEntity){
        User user = userDB.getUserByEmail(userDomainEntity.getEmail()).orElse(null);
        if(user == null){
            userDomainEntity.setCreatedAt(Instant.now());
            userDomainEntity.setUpdatedAt(Instant.now());
            userDomainEntity.setRenewalDate(LocalDate.now().minusDays(1));
            mebershipRenewalService.initRenewMembership(userDomainEntity);
            user = userDB.saveUser(userMapper.userDomainToUser(userDomainEntity));
            renewMembershipUseCase.execute(user.getId());
        }
    }

}
