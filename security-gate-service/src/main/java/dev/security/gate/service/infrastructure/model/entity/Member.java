package dev.security.gate.service.infrastructure.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members", schema = "public")
public class Member {
    @Id
    @Column(name = "user_id", nullable = false)
    private UUID id;

    @Column(name = "membership_status", length = 20)
    private String membershipStatus;

    @Column(name = "renewal_date")
    private LocalDate renewalDate;

}