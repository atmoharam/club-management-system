package dev.members.application.service;

import org.aspectj.asm.internal.Relationship;

import java.util.UUID;

public class CreateRelationshipUseCase {


    public void execute(UUID firstUserID, UUID secondUserID) {
        // 1 - get first user from DB
        // 2 - get second user from DB
        // 3 - calling service to create relationship object
        // 4 - saving the relationship


    }
}
