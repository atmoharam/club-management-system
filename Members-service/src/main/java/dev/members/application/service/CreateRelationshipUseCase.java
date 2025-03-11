package dev.members.application.service;

import dev.members.domain.model.entities.FamilyMemberDomainEntity;
import dev.members.domain.service.MemberCreateRelationship;
import dev.members.infrastructure.adapter.FamilyMemberDB;
import dev.members.infrastructure.adapter.UserDB;
import dev.members.infrastructure.model.entites.FamilyMember;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.mapper.FamilyMemberMapper;
import dev.members.infrastructure.model.mapper.UserMapper;
import org.aspectj.asm.internal.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateRelationshipUseCase {

    @Autowired
    UserDB userDB;
    @Autowired
    FamilyMemberDB familyMemberDB;
    @Autowired
    MemberCreateRelationship memberCreateRelationship;
    @Autowired
    UserMapper userMapper;
    @Autowired
    FamilyMemberMapper familyMemberMapper;

    public void execute(UUID firstUserID,
                        UUID secondUserID,
                        String relation) {
        // 1 - get first user from DB
        User firstUser = userDB.getUserByID(firstUserID).orElse(null);
        // 2 - get second user from DB
        User secondUser = userDB.getUserByID(firstUserID).orElse(null);
        // 3 - calling service to create relationship object
        if(firstUser != null && secondUser != null) {
            FamilyMemberDomainEntity relationship =
                    memberCreateRelationship.createRelationship(
                    userMapper.UserToDomainEntity(firstUser),
                    userMapper.UserToDomainEntity(secondUser),
                            relation
                    );

            // 4 - saving the relationship
            familyMemberDB.
                    save(familyMemberMapper.
                            familyMemberDomainEntityToFamilyMemberEntity(
                                    relationship));
        }


    }
}
