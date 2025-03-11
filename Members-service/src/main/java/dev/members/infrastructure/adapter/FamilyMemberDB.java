package dev.members.infrastructure.adapter;

import dev.members.domain.repository.FamilyMemberRepositoryInterface;
import dev.members.infrastructure.model.entites.FamilyMember;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.repository.FamilyMemberRepository;
import dev.members.infrastructure.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FamilyMemberDB implements FamilyMemberRepositoryInterface {
    @Autowired
    private FamilyMemberRepository familyMemberRepository;
    @Autowired
    private UserRepository userRepository;

    public List<FamilyMember> getFamilyMembers(UUID userId) {
        User user = userRepository.findById(userId).get();
        return familyMemberRepository.findAllByUser(user);
    }
    public FamilyMember Save(FamilyMember familyMember) {
        return familyMemberRepository.save(familyMember);
    }
    public FamilyMember save(FamilyMember familyMember) {
        return familyMemberRepository.save(familyMember);
    }
}
