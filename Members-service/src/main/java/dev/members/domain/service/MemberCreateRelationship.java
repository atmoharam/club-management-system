package dev.members.domain.service;

import dev.common.domain.cons.Relation;
import dev.members.domain.model.entities.FamilyMemberDomainEntity;
import dev.members.domain.model.entities.UserDomainEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class MemberCreateRelationship {

    public FamilyMemberDomainEntity createRelationship
            (UserDomainEntity member1,
             UserDomainEntity member2,
             String relation) {
        return FamilyMemberDomainEntity.builder().
                id(UUID.randomUUID()).
                user(member1).
                familyMember(member2).
                relation(Relation.valueOf(relation))
                .createdAt(Instant.now())
                .build();
    }
}
