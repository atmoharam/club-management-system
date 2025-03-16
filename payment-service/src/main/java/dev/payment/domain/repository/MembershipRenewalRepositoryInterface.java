package dev.payment.domain.repository;

import dev.payment.infrastructure.model.entity.MembershipRenewal;

public interface MembershipRenewalRepositoryInterface {
    MembershipRenewal save(MembershipRenewal membershipRenewal);
}
