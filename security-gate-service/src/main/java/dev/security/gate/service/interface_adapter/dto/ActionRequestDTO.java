package dev.security.gate.service.interface_adapter.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionRequestDTO {
    private UUID id;
    private String gate;
}
