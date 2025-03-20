package dev.sport.service.domain.model.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class UserSportDomainEntity {
    private UUID userId;
    private SportDomainEntity sportDomainEntity;
}
