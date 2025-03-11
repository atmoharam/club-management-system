package dev.members.domain.repository;

import dev.members.infrastructure.model.entites.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryInterface {
    public Optional<User> getUserByEmail(String email);
    public Optional<User> getUserByID(UUID id);
    public User saveUser(User user);
}
