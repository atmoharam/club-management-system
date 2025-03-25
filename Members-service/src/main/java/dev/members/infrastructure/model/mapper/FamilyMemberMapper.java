package dev.members.infrastructure.model.mapper;

import dev.common.domain.cons.Relation;
import dev.members.domain.model.entities.FamilyMemberDomainEntity;
import dev.members.infrastructure.model.entites.FamilyMember;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyMemberMapper {

    @Autowired
    UserMapper userMapper;


    public FamilyMember familyMemberDomainEntityToFamilyMemberEntity(FamilyMemberDomainEntity familyMemberDomainEntity) {
        return FamilyMember.builder().
                user(userMapper.userDomainToUser(familyMemberDomainEntity.getUser()))
                .familyMember(userMapper.userDomainToUser(familyMemberDomainEntity.getFamilyMember()))
                        .relation(familyMemberDomainEntity.getRelation().toString())
                                .createdAt(familyMemberDomainEntity.getCreatedAt()).
                build();
    }

    public FamilyMemberDomainEntity familyMemberEntityToFamilyMemberDomainEntity(FamilyMember familyMember) {
        return FamilyMemberDomainEntity.builder().
                user(userMapper.UserToDomainEntity(familyMember.getUser()))
                .familyMember(userMapper.UserToDomainEntity(familyMember.getFamilyMember()))
                .relation(Relation.valueOf(familyMember.getRelation()))
                .createdAt(familyMember.getCreatedAt()).
                build();
    }
}
