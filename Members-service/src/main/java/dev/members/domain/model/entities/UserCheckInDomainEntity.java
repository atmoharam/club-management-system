package dev.members.domain.model.entities;

import dev.common.domain.cons.Action;
import dev.common.domain.cons.Relation;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserCheckInDomainEntity {
    private UUID id;
    private UserDomainEntity user;
    private Instant timestamp;
    private Action action;
}
