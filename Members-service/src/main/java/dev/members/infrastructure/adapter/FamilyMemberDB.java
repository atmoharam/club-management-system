package dev.members.infrastructure.adapter;

import dev.members.domain.repository.FamilyMemberRepositoryInterface;
import dev.members.infrastructure.model.repository.FamilyMemberRepository;

public class FamilyMemberDB implements FamilyMemberRepositoryInterface {
    private FamilyMemberRepository familyMemberRepository;
}
