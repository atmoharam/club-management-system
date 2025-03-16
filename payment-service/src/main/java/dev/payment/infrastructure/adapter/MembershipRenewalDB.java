package dev.payment.infrastructure.adapter;

import dev.payment.domain.repository.MembershipRenewalRepositoryInterface;
import dev.payment.infrastructure.model.entity.MembershipRenewal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Builder
public class MembershipRenewalDB implements MembershipRenewalRepositoryInterface {

    @Override
    public MembershipRenewal save(MembershipRenewal membershipRenewal) {
        return null;
    }
}
