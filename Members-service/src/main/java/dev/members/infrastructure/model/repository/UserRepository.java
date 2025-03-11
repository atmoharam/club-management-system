package dev.members.infrastructure.model.repository;

import dev.members.infrastructure.model.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findById(UUID id);
}
