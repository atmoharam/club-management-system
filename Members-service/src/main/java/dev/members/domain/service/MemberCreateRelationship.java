package dev.members.domain.service;

import dev.members.domain.model.entities.FamilyMemberDomainEntity;
import dev.members.domain.model.entities.UserDomainEntity;

import java.util.UUID;

public class MemberCreateRelationship {

    public FamilyMemberDomainEntity createRelationship(UserDomainEntity member1, UserDomainEntity member2) {
        return FamilyMemberDomainEntity.builder().
                id(UUID.randomUUID()).
                user(member1).
                familyMember(member2)
                .build();
    }
}
