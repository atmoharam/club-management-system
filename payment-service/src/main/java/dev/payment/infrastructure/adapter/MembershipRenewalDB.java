package dev.payment.infrastructure.adapter;

import dev.payment.domain.repository.MembershipRenewalRepositoryInterface;
import dev.payment.infrastructure.model.entity.MembershipRenewal;
import dev.payment.infrastructure.model.repository.MembershipRenewalRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Builder
public class MembershipRenewalDB implements MembershipRenewalRepositoryInterface {
    @Autowired
    MembershipRenewalRepository membershipRenewalRepository;
    @Override
    public MembershipRenewal save(MembershipRenewal membershipRenewal) {
        return membershipRenewalRepository.save(membershipRenewal);
    }
}
