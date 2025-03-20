package dev.sport.service.domain.model.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class SportDomainEntity {
    private String name;
    private String description;

}
