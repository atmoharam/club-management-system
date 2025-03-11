package dev.members.domain.service;

import dev.members.domain.model.entities.UserDomainEntity;
import dev.members.domain.model.entities.UserSportDomainEntity;

import java.util.UUID;

public class MemberSubscribeSport {

    public UserSportDomainEntity userSubscribeSport(UserDomainEntity user , UUID sportId) {
        return UserSportDomainEntity.
                builder().
                user(user).
                sportId(sportId).
                id(UUID.randomUUID()).
                build();

    }
}
