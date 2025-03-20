package dev.security.gate.service.application;

import dev.common.domain.cons.MembershipStatus;
import dev.security.gate.service.infrastructure.adapter.MembersDB;
import dev.security.gate.service.infrastructure.model.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class UserRenewalMembership {

    @Autowired
    MembersDB membersDB;



    public void renewalMembership(UUID userId ,
                                  MembershipStatus status,
                                  LocalDate renewalDate) {
        Member member = membersDB.findById(userId).orElse(null);
        if (member == null) {
            member = Member.builder()
                    .id(userId)
                    .membershipStatus(status.toString())
                    .renewalDate(renewalDate)
                    .build();
        }
        else{
            member.setMembershipStatus(status.toString());
            member.setRenewalDate(renewalDate);
        }
        membersDB.save(member);

    }
}
