package dev.members.interface_adapters.mapper;

import dev.common.domain.cons.MembershipStatus;
import dev.members.domain.model.entities.UserDomainEntity;
import dev.members.interface_adapters.dto.CreateUserDTO;

import java.time.Instant;
import java.time.LocalDate;

public class UserApiMapper {

    public UserDomainEntity userRequestDTOtoUserDomian(CreateUserDTO userDTO){
        return UserDomainEntity.builder()
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .phone(userDTO.getPhone())
                .address(userDTO.getAddress())
                .dateOfBirth(userDTO.getDateOfBirth())
                .build();
    }
}
