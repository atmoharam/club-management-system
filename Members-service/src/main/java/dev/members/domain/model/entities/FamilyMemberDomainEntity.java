package dev.members.domain.model.entities;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class FamilyMemberDomainEntity {
    private UUID id;
    private UserDomainEntity user;
    private UserDomainEntity familyMember;


}
