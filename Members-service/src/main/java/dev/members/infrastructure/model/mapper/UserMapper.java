package dev.members.infrastructure.model.mapper;

import dev.common.domain.cons.MembershipStatus;
import dev.members.domain.model.entities.UserDomainEntity;
import dev.members.domain.model.valueobject.Address;
import dev.members.domain.model.valueobject.PhoneNumber;
import dev.members.infrastructure.model.entites.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User userDomainToUser(UserDomainEntity user) {
        return User.builder()
                .id(user.getId())
                .email(user.getEmail())
                .phone(user.getPhone().PhoneNumberString())
                .name(user.getName())
                .address(user.getFullAddress())
                .dateOfBirth(user.getDateOfBirth())
                .renewalDate(user.getRenewalDate())
                .membershipStatus(user.getMembershipStatus().toString())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();

    }
    public UserDomainEntity UserToDomainEntity(User user) {

        return UserDomainEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .phone(new PhoneNumber(user.getPhone()))
                .address(new Address(user.getAddress()))
                .dateOfBirth(user.getDateOfBirth())
                .membershipStatus(MembershipStatus.valueOf(user.getMembershipStatus().toString()))
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
