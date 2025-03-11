package dev.members.domain.model.entities;

import dev.common.domain.cons.Relation;
import lombok.*;

import java.time.Instant;
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
    private Relation relation;
    private Instant createdAt;


    public void AddFamilyMember(UserDomainEntity User) {
        this.familyMember = User;
    }

}
