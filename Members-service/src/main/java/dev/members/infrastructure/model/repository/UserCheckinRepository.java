package dev.members.infrastructure.model.repository;

import dev.members.infrastructure.model.entites.UserCheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserCheckinRepository extends JpaRepository<UserCheckIn, UUID> {
}
