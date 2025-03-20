package dev.sport.service.interface_adapters.dto;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {
    UUID SportId;
    UUID TarinerId;
    Instant startTime;
    Instant endTime;
    String location;
}
