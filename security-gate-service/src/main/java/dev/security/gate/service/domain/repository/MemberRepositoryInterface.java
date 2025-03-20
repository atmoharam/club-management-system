package dev.security.gate.service.domain.repository;

import dev.security.gate.service.infrastructure.model.entity.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepositoryInterface {
    Optional<Member> findById(UUID id);
    Member save(Member member);

}
