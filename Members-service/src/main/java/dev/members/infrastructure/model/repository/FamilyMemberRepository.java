package dev.members.infrastructure.model.repository;

import dev.members.infrastructure.model.entites.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, UUID> {

}
