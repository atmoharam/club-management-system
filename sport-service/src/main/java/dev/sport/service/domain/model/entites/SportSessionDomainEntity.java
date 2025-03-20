package dev.sport.service.domain.model.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class SportSessionDomainEntity {
    private UUID trainerId;
    private Instant startTime;
    private Instant endTime;
    private String location;
}
