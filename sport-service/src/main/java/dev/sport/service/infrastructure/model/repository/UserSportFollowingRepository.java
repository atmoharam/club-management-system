package dev.sport.service.infrastructure.model.repository;

import dev.sport.service.infrastructure.model.entites.UserSportFollowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface UserSportFollowingRepository extends JpaRepository<UserSportFollowing, UUID> {
}
