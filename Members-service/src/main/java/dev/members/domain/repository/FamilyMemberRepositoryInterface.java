package dev.members.domain.repository;

import dev.members.infrastructure.model.entites.FamilyMember;

import java.util.List;
import java.util.UUID;

public interface FamilyMemberRepositoryInterface {

    public FamilyMember save(FamilyMember familyMember);
    public List<FamilyMember> getFamilyMembers(UUID userId);
    public void deleteFamilyMember(UUID userId, UUID familyMemberId);
}
