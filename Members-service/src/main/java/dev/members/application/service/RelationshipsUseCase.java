package dev.members.application.service;

import dev.members.domain.model.entities.FamilyMemberDomainEntity;
import dev.members.domain.service.MemberCreateRelationship;
import dev.members.infrastructure.adapter.FamilyMemberDB;
import dev.members.infrastructure.adapter.UserDB;
import dev.members.infrastructure.model.entites.FamilyMember;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.mapper.FamilyMemberMapper;
import dev.members.infrastructure.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class RelationshipsUseCase {

    final
    UserDB userDB;
    final
    FamilyMemberDB familyMemberDB;
    final
    MemberCreateRelationship memberCreateRelationship;
    final
    UserMapper userMapper;
    final
    FamilyMemberMapper familyMemberMapper;

    @Autowired
    public RelationshipsUseCase(UserDB userDB, FamilyMemberDB familyMemberDB, MemberCreateRelationship memberCreateRelationship, UserMapper userMapper, FamilyMemberMapper familyMemberMapper) {
        this.userDB = userDB;
        this.familyMemberDB = familyMemberDB;
        this.memberCreateRelationship = memberCreateRelationship;
        this.userMapper = userMapper;
        this.familyMemberMapper = familyMemberMapper;
    }

    @Transactional
    public FamilyMember create(UUID firstUserID,
                               UUID secondUserID,
                               String relation) {
        User firstUser = userDB.getUserByID(firstUserID).orElse(null);
        User secondUser = userDB.getUserByID(secondUserID).orElse(null);
        if(firstUser != null && secondUser != null) {
            FamilyMemberDomainEntity relationship =
                    memberCreateRelationship.createRelationship(
                    userMapper.UserToDomainEntity(firstUser),
                    userMapper.UserToDomainEntity(secondUser),
                            relation
                    );
            return familyMemberDB.
                    save(familyMemberMapper.
                            familyMemberDomainEntityToFamilyMemberEntity(
                                    relationship));
        }
        else {
            return null;
        }
    }

    public List<FamilyMember> findAll(UUID userID) {
       return familyMemberDB.getFamilyMembers(userID);


    }

    @Transactional
    public void delete(UUID userID , UUID secondUserID) {
        familyMemberDB.deleteFamilyMember(userID,secondUserID);

    }

}
