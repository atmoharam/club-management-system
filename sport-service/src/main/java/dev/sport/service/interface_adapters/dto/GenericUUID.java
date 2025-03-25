package dev.sport.service.interface_adapters.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class GenericUUID {
    private UUID value;
}
