package dev.members.domain.model.entities;

import dev.common.domain.entity.AggregateRoot;
import dev.common.domain.cons.MembershipStatus;
import dev.members.domain.model.valueobject.Address;
import dev.members.domain.model.valueobject.PhoneNumber;
import lombok.*;


import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserDomainEntity extends AggregateRoot {
    private UUID id;
    private String name;
    private String email;
    private PhoneNumber phone;
    private LocalDate dateOfBirth;
    private Address address;
    private MembershipStatus membershipStatus;
    private LocalDate renewalDate;
    private Instant createdAt;
    private Instant updatedAt;


    public void renewMembership() {
        this.renewalDate = LocalDate.now().plusYears(1);
        this.membershipStatus = MembershipStatus.Active;
    }

    public void initRenewMembership(){
        this.membershipStatus = MembershipStatus.Pending;
    }


    public boolean isActive() {
        return membershipStatus == MembershipStatus.Active;
    }

    public String getFullAddress()
    {
        return address.getCity() + "," + address.getStreet() + "," + address.getZip();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
