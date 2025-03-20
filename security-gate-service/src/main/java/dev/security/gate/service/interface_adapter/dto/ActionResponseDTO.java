package dev.security.gate.service.interface_adapter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ActionResponseDTO {
    private String status;
    private String message;
}
