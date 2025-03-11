package dev.members.domain.model.entities;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder(toBuilder = true)
public class FamilyMemberDomainEntity {
    private UUID id;
    private UserDomainEntity user;
    private UserDomainEntity familyMember;

    public void AddFamilyMember(UserDomainEntity User) {
        this.familyMember = User;
    }

}
