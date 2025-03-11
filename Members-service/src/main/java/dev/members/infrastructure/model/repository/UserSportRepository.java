package dev.members.infrastructure.model.repository;

import dev.members.infrastructure.model.entites.UserSport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserSportRepository extends JpaRepository<UserSport, UUID> {
}
