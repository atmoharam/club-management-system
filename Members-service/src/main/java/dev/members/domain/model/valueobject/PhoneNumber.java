package dev.members.domain.model.valueobject;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PhoneNumber {
    String countryCode;
    String number;
}
