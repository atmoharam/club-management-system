package dev.members.infrastructure.model.repository;

import dev.members.infrastructure.model.entites.UserSport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserSportRepository extends JpaRepository<UserSport, UUID> {

    Optional<UserSport> findByUserId(UUID userId);

}
