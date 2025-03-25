package dev.members.infrastructure.model.repository;

import dev.members.infrastructure.model.entites.FamilyMember;
import dev.members.infrastructure.model.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, UUID> {

    List<FamilyMember> findAllByUser(User user);
    List<FamilyMember> findAllByFamilyMember(User user);
    FamilyMember save(FamilyMember familyMember);
    void deleteAllByUserAndFamilyMember(User user, User familyMember);

}
