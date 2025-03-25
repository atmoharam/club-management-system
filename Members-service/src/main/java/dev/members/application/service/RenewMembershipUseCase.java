package dev.members.application.service;

import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipRequest;
import dev.kafka.service.model.dev.kafka.avro.UserRenewMembershipResponse;
import dev.members.domain.model.entities.UserDomainEntity;
import dev.members.domain.service.MebershipRenewalService;
import dev.members.infrastructure.adapter.UserDB;
import dev.members.infrastructure.messaging.out.UserRenewalRequestPublisher;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class RenewMembershipUseCase {
    UserDB userDB;
    private UserRenewalRequestPublisher userRenewalRequestPublisher;
    private final UserMapper userMapper;
    MebershipRenewalService mebershipRenewalService;

    public void execute(UUID memberId) {
        UserRenewMembershipRequest userRenewMembershipRequest =
                UserRenewMembershipRequest.newBuilder().
                setUserId(memberId.toString())
                        .build();

        User user = userDB.
                getUserByID(memberId).orElse(null);
        UserDomainEntity userDomainEntity = userMapper.UserToDomainEntity(user);
        mebershipRenewalService.initRenewMembership(userDomainEntity);
        userDB.saveUser(userMapper.userDomainToUser(userDomainEntity));
        userRenewalRequestPublisher.publish(userRenewMembershipRequest);
    }

    public void execute(UserRenewMembershipResponse userRenewMembershipResponse) {
        User user = userDB.
                getUserByID(UUID.fromString(userRenewMembershipResponse.getUserId().toString())).orElse(null);
        UserDomainEntity userDomainEntity = userMapper.UserToDomainEntity(user);
        mebershipRenewalService.renewMembership(userDomainEntity);
        userDB.saveUser(userMapper.userDomainToUser(userDomainEntity));
    }

    public boolean isSuccessful(UUID memberId) {
        User user = userDB.getUserByID(memberId).orElse(null);
        if (user != null) {
            return (! user.getMembershipStatus().equals("Expired"));
        }
        return false;
    }

}
