package dev.payment.infrastructure.model.repository;

import dev.payment.infrastructure.model.entity.MembershipRenewal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MembershipRenewalRepository extends JpaRepository<MembershipRenewal, UUID> {
}
