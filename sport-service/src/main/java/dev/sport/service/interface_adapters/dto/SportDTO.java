package dev.sport.service.interface_adapters.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class SportDTO {
    String name;
    String description;
}
