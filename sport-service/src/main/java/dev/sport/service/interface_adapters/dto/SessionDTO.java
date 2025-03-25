package dev.sport.service.interface_adapters.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {
    String sportId;
    String tarinerId;
    String startTime;
    String endTime;
    String location;
}
