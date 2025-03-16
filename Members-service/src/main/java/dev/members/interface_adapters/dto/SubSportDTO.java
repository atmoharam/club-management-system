package dev.members.interface_adapters.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubSportDTO {
    String userID;
    String sportID;
}
