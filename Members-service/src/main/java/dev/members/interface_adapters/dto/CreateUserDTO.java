package dev.members.interface_adapters.dto;

import dev.common.domain.cons.MembershipStatus;
import dev.members.domain.model.valueobject.Address;
import dev.members.domain.model.valueobject.PhoneNumber;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Setter
@Getter
public class CreateUserDTO {

    private String name;
    private String email;
    private PhoneNumber phone;
    private LocalDate dateOfBirth;
    private Address address;


}
