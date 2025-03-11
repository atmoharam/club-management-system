package dev.members.application.service;

import dev.kafka.avro.UserRenewMembershipRequest;
import dev.kafka.avro.UserRenewMembershipResponse;
import dev.members.domain.model.entities.UserDomainEntity;
import dev.members.domain.service.MebershipRenewalService;
import dev.members.infrastructure.adapter.UserDB;
import dev.members.infrastructure.messaging.out.UserRenewalRequestPublisher;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RenewMembershipUseCase {
    @Autowired
    UserDB userDB;
    @Autowired
    private UserRenewalRequestPublisher userRenewalRequestPublisher;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    MebershipRenewalService mebershipRenewalService;
    long timestamp = System.currentTimeMillis();


    public void execute(UUID memberId) {
        // 1 - create request to payment service
        UserRenewMembershipRequest userRenewMembershipRequest =
                UserRenewMembershipRequest.newBuilder().
                setUserId(memberId.toString()).
                setRequestTimestamp(System.currentTimeMillis())
                        .build();

        User user = userDB.
                getUserByID(memberId).orElse(null);
        UserDomainEntity userDomainEntity = userMapper.UserToDomainEntity(user);
        // 5 - use domain logic to renew membership
        mebershipRenewalService.initRenewMembership(userDomainEntity);
        User updated = userDB.saveUser(userMapper.userDomainToUser(userDomainEntity));
        userRenewalRequestPublisher.publish(userRenewMembershipRequest);
    }

    // 2 - get success response from payment service
    public void execute(UserRenewMembershipResponse userRenewMembershipResponse) {
        // 3 - get user from DB
        User user = userDB.
                getUserByID(UUID.fromString(userRenewMembershipResponse.getUserId().toString())).orElse(null);
        // 4 - map to default domain entity
        UserDomainEntity userDomainEntity = userMapper.UserToDomainEntity(user);
        // 5 - use domain logic to renew membership
        mebershipRenewalService.renewMembership(userDomainEntity);
        // 6 - saving in DB
        User updated = userDB.saveUser(userMapper.userDomainToUser(userDomainEntity));
    }
}
