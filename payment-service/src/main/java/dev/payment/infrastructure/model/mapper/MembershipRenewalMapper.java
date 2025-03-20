package dev.payment.infrastructure.model.mapper;

import dev.payment.domain.model.entites.MembershipRenewalDomainEntity;
import dev.payment.infrastructure.model.entity.MembershipRenewal;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@Service
public class MembershipRenewalMapper {
    public MembershipRenewal membershipRenewalDomainToEntity(MembershipRenewalDomainEntity membershipRenewalDomainEntity) {
        return MembershipRenewal.builder()
                .userId(membershipRenewalDomainEntity.getUserId())
                .renewalDate(LocalDate.from(membershipRenewalDomainEntity.
                        getTimestamp().
                        atZone(ZoneId.systemDefault()).toLocalDate()
                ))
                .amount(membershipRenewalDomainEntity.getAmount())
                .build();
    }

    public MembershipRenewalDomainEntity membershipToMembershipRenewalDomain(MembershipRenewal membershipRenewal) {
        return MembershipRenewalDomainEntity.builder()
                .userId(membershipRenewal.getUserId())
                .id(membershipRenewal.getId())
                .amount(membershipRenewal.getAmount())
                .timestamp(Instant.from(membershipRenewal.getRenewalDate()))
                .build();
    }
}
