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
    @Override

    public List<FamilyMember> getFamilyMembers(UUID userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<FamilyMember> L1 = familyMemberRepository.findAllByFamilyMember(user);
            L1.addAll(familyMemberRepository.findAllByUser(user));
            return L1;
        }
        return null;
    }

    @Override
    public void deleteFamilyMember(UUID userId, UUID familyMemberId) {
        User user = userRepository.findById(userId).orElse(null);
        User secondUser = userRepository.findById(familyMemberId).orElse(null);
        if (user != null && secondUser != null) {
            familyMemberRepository.deleteAllByUserAndFamilyMember(user, secondUser);
            familyMemberRepository.deleteAllByUserAndFamilyMember(secondUser, user);
        }
    }
    @Override
    public FamilyMember save(FamilyMember familyMember) {
        return familyMemberRepository.save(familyMember);
    }
}
