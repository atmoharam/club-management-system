package dev.security.gate.service.domain.model.entites;

import dev.common.domain.cons.MembershipStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DomainMember {
    private UUID id;
    private MembershipStatus membershipStatus;
    private LocalDate renewalDate;

}
