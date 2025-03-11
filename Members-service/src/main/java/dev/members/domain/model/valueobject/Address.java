package dev.members.domain.model.valueobject;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Address {
    private UUID id;
    private String street;
    private String city;
    private String zip;

    public Address(String fullAddress) {

        String[] parts = fullAddress.split(",");
        if (parts.length == 3) {
            Address.builder()
                    .city(parts[0])
                    .zip(parts[2])
                    .street(parts[1])
                    .id(UUID.randomUUID())
                    .build();
        }

    }

}
