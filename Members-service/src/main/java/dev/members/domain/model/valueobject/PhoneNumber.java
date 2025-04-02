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

            PhoneNumber.builder().countryCode(number.substring(0,2)).
                    number(number.substring(2)).build();
    }

    public String PhoneNumberString() {
        return countryCode + number;
    }

}
