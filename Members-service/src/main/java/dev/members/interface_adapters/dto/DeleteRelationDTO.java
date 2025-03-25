package dev.members.interface_adapters.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Setter
@Getter
public class DeleteRelationDTO{
    private UUID firstUserId;
    private UUID secondUserId;
}