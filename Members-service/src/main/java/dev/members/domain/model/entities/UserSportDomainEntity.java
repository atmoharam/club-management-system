package dev.members.domain.model.entities;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserSportDomainEntity {
    private UUID id;
    private UserDomainEntity user;
    private UUID sportId;
    private Instant subscribedAt;

}
