package dev.members.domain.model.valueobject;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Address {
    private int id;
    private String street;
    private String city;
    private String zip;

}
