package dev.members.interface_adapters.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Setter
@Getter
public class RelationDTO {
    private String firstUserId;
    private String secondUserId;
    private String relationType;
}


