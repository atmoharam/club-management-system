package dev.security.gate.service.infrastructure.model.repository;

import dev.security.gate.service.infrastructure.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {

}
