package dev.members.domain.model.valueobject;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PhoneNumber {
    String countryCode;
    String number;

    public PhoneNumber(String number) {
        String[] parts = number.split("-");
        if (parts.length == 2) {
            PhoneNumber.builder().countryCode(parts[0]).
                    number(parts[1]).build();
        }
    }

    public String PhoneNumberString() {
        return countryCode + "-" + number;
    }

}
