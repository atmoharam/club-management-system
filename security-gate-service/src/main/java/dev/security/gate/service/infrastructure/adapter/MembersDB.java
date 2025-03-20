package dev.security.gate.service.infrastructure.adapter;

import dev.security.gate.service.domain.repository.MemberRepositoryInterface;
import dev.security.gate.service.infrastructure.model.entity.Member;
import dev.security.gate.service.infrastructure.model.repository.MemberRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MembersDB implements MemberRepositoryInterface {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Optional<Member> findById(UUID id) {
        return memberRepository.findById(id) ;
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

}
