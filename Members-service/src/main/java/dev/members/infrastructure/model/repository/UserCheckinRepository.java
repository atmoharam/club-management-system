package dev.members.infrastructure.model.repository;

import dev.members.infrastructure.model.entites.UserCheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserCheckinRepository extends JpaRepository<UserCheckIn, UUID> {
}
